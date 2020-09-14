package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.ShoppingCartItem;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

@JsonSerialize
public class ShoppingCartItemResponse {

    private Long id;
    private ProductResponse product;
    private BigDecimal price;

    public ShoppingCartItemResponse(final ShoppingCartItem shoppingCartItem) {
        this.id = shoppingCartItem.getId();
        this.product = new ProductResponse(shoppingCartItem.getProduct());
        this.price = shoppingCartItem.getPrice();
    }

    public Long getId() {
        return id;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
