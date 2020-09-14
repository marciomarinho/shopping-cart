package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.ShoppingCart;

public class ShoppingCartId {

    private Long id;

    public ShoppingCartId(final ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
    }

    public Long getId() {
        return this.id;
    }
}
