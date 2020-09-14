package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.ShoppingCart;

public class ShoppingCartIdResponse {

    private Long id;

    public ShoppingCartIdResponse(final ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
    }

    public Long getId() {
        return this.id;
    }
}
