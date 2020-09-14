package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductResponseTest {

    private ProductResponse productResponse;

    @Test
    void shouldCreateNewProductResponse() {
        final Product product = new Product("abc", new BigDecimal("127.44"));
        productResponse = new ProductResponse(product);
        assertEquals(productResponse.getDescription(), product.getDescription());
        assertNull(productResponse.getId());
    }
}