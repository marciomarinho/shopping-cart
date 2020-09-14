package au.com.riosoftware.scart.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
public class ShoppingCart {

    private static final BigDecimal SALES_TAXES = new BigDecimal("0.125");

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal total;

    private BigDecimal salesTaxes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShoppingCartItem> items;


    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.total = new BigDecimal("0.0").setScale(2, RoundingMode.HALF_UP);
    }

    public ShoppingCart(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public List<ShoppingCartItem> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void addItem(final Product product) {
        this.items.add(new ShoppingCartItem(product));
        final BigDecimal productTax = product.getPrice().multiply(SALES_TAXES).setScale(2, RoundingMode.HALF_UP);;
        this.salesTaxes = isNull(salesTaxes) ? productTax : salesTaxes.add(productTax.setScale(2, RoundingMode.HALF_UP));
        this.total = this.total.add(product.getPrice().add(productTax)).setScale(2, RoundingMode.HALF_UP);
    }

}
