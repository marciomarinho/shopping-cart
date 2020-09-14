package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.Product;
import au.com.riosoftware.scart.model.ShoppingCart;
import au.com.riosoftware.scart.model.ShoppingCartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ShoppingCartResponseTest {

    @Mock
    private ShoppingCart shoppingCart;

    private List<ShoppingCartItem> items;

    private ShoppingCartResponse shoppingCartResponse;

    @BeforeEach
    void setup() {
        items = new ArrayList<>();
    }

    @Test
    void shouldCreateNewShoppingCartResponse() {
        items.add(new ShoppingCartItem(
                        new Product("aaaa",
                                new BigDecimal("33.95"))
                )
        );
        items.add(new ShoppingCartItem(
                        new Product("bbbb",
                                new BigDecimal("44.93"))
                )
        );
        given(shoppingCart.getId()).willReturn(Long.valueOf(33));
        given(shoppingCart.getItems()).willReturn(items);
        given(shoppingCart.getTotal()).willReturn(new BigDecimal("78.88"));
        shoppingCartResponse = new ShoppingCartResponse(shoppingCart);
        assertEquals(shoppingCartResponse.getId(), Long.valueOf(33));
        assertEquals(shoppingCartResponse.getTotal(), new BigDecimal("78.88"));
        assertEquals(shoppingCartResponse.getItems().size(), 2);
    }

}