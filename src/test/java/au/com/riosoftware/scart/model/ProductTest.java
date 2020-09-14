package au.com.riosoftware.scart.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductTest {

    private Product product;

    @Test
    public void shouldCreateProduct() {
        product = new Product("abcdef", new BigDecimal("55.326779464").setScale(2, RoundingMode.HALF_UP));
        assertEquals(product.getDescription(), "abcdef");
        assertEquals(product.getPrice(), new BigDecimal("55.33"));
        assertNull(product.getId());
    }
}