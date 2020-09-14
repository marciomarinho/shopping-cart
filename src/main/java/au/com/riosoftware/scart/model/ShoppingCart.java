package au.com.riosoftware.scart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal total;

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

    public List<ShoppingCartItem> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void addItem(final Product product) {
        this.items.add(new ShoppingCartItem(product));
        this.total = this.total.add(product.getPrice()).setScale(2, RoundingMode.HALF_UP);
    }

}
