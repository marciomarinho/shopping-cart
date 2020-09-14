package au.com.riosoftware.scart.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    private List<Product> products;
    private ShoppingCart shoppingCart;

    @BeforeEach()
    public void setup() {
        products = new ArrayList<>();
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void shouldCalculateTotalForStep1() {

        products.add(new Product("Dove Soap", new BigDecimal("39.99")));
        products.add(new Product("Dove Soap", new BigDecimal("39.99")));
        products.add(new Product("Dove Soap", new BigDecimal("39.99")));
        products.add(new Product("Dove Soap", new BigDecimal("39.99")));
        products.add(new Product("Dove Soap", new BigDecimal("39.99")));

        for (Product product : products) {
            shoppingCart.addItem(product);
        }

        assertEquals(shoppingCart.getTotal(), new BigDecimal("199.95"));
    }
}