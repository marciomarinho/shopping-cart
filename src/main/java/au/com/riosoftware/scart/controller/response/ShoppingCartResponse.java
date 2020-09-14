package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.ShoppingCart;
import au.com.riosoftware.scart.model.ShoppingCartItem;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"id", "total", "items"})
public class ShoppingCartResponse {

    private Long id;

    private BigDecimal total;

    private List<ShoppingCartItemResponse> items;

    public ShoppingCartResponse(final ShoppingCart shoppingCart) {
        this.items = new ArrayList<>();
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getItems()) {
            items.add(new ShoppingCartItemResponse(shoppingCartItem));
        }
        this.id = shoppingCart.getId();
        this.total = shoppingCart.getTotal();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ShoppingCartItemResponse> getItems() {
        return items;
    }
}
