package au.com.riosoftware.scart.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private BigDecimal price;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(final Product product) {
        this.product = product;
        this.price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
