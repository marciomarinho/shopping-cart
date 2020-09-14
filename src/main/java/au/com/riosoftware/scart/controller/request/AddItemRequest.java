package au.com.riosoftware.scart.controller.request;

public class AddItemRequest {

    private Long shoppingCartId;
    private Long productId;
    private int quantity;

    public AddItemRequest(final Long shoppingCartId,
                          final Long productId,
                          final int quantity) {
        this.shoppingCartId = shoppingCartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
