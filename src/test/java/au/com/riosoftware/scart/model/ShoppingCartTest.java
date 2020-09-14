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

        assertEquals(new BigDecimal("224.95"), shoppingCart.getTotal());
        assertEquals(new BigDecimal("25.00"), shoppingCart.getSalesTaxes());
    }

    @Test
    public void shouldCalculateTotalForStep2() {

        for (int i = 0; i < 8; i++) {
            final Product product = new Product("Dove Soap", new BigDecimal("39.99"));
            shoppingCart.addItem(product);
        }

        assertEquals(new BigDecimal("359.92"), shoppingCart.getTotal());
        assertEquals(new BigDecimal("40.00"), shoppingCart.getSalesTaxes());

    }

    @Test
    public void shouldCalculateTotalForStep3() {

        final Product doveSoap = new Product("Dove Soap", new BigDecimal("39.99"));
        final Product axeDeo = new Product("Axe Deo", new BigDecimal("99.99"));

        shoppingCart.addItem(doveSoap);
        shoppingCart.addItem(doveSoap);
        shoppingCart.addItem(axeDeo);
        shoppingCart.addItem(axeDeo);

        assertEquals(new BigDecimal("314.96"), shoppingCart.getTotal());
        assertEquals(new BigDecimal("35.00"), shoppingCart.getSalesTaxes());

    }
}