package au.com.riosoftware.scart.service;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.controller.response.ShoppingCartResponse;
import au.com.riosoftware.scart.model.Product;
import au.com.riosoftware.scart.model.ShoppingCart;
import au.com.riosoftware.scart.controller.response.ShoppingCartId;
import au.com.riosoftware.scart.repository.ProductRepository;
import au.com.riosoftware.scart.repository.ShoppingCartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @Mock
    private ProductRepository productRepository;

    private ShoppingCartService shoppingCartService;

    @BeforeEach
    public void setup() {
        shoppingCartService = new ShoppingCartService(shoppingCartRepository, productRepository);
    }

    @Test
    public void shouldReturnNewShoppingCartId() {
        given(shoppingCartRepository.save(any(ShoppingCart.class))).willReturn(new ShoppingCart(678l));
        ShoppingCartId actual = shoppingCartService.getShoppingCartId();
        assertEquals(actual.getId(), Long.valueOf(678));
        verify(shoppingCartRepository).save(any(ShoppingCart.class));
    }

    @Test
    public void shouldAddItem() {
        final Product product = new Product("abcd", new BigDecimal("33.99"));
        final AddItemRequest addItemRequest = new AddItemRequest(1l, 3l, 4);
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(product);

        given(shoppingCartRepository
                .findById(addItemRequest.getShoppingCartId())).willReturn(Optional.of(shoppingCart));

        given(productRepository.findById(addItemRequest.getProductId())).willReturn(Optional.of(product));
        ShoppingCartResponse response = shoppingCartService.addItem(addItemRequest);
        verify(shoppingCartRepository).findById(addItemRequest.getShoppingCartId());
        verify(shoppingCartRepository).save(shoppingCart);
    }
}