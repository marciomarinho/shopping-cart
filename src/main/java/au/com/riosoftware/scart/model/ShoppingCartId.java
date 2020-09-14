package au.com.riosoftware.scart.model;

public class ShoppingCartId {

    private Long id;

    public ShoppingCartId(final ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
    }

    public Long getId() {
        return this.id;
    }
}
