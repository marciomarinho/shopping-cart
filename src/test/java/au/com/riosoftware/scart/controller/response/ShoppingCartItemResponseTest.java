package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.Product;
import au.com.riosoftware.scart.model.ShoppingCartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ShoppingCartItemResponseTest {

    private ShoppingCartItemResponse shoppingCartItemResponse;

    @Test
    void shouldCreateNewShoppingCartItemResponse() {
        final Product doveSoap = new Product("Dove Soap",
                new BigDecimal("33.99")
                        .setScale(2, RoundingMode.HALF_UP));
        final ShoppingCartItem shoppingCartItem = new ShoppingCartItem(doveSoap);
        final ProductResponse productResponse = new ProductResponse(shoppingCartItem.getProduct());
        shoppingCartItemResponse = new ShoppingCartItemResponse(shoppingCartItem);
        assertEquals(shoppingCartItemResponse.getProduct().getDescription(), productResponse.getDescription());
        assertEquals(shoppingCartItemResponse.getPrice(), doveSoap.getPrice());
        assertNull(shoppingCartItemResponse.getId());
    }
}