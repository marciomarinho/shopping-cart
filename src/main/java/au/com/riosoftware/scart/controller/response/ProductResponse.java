package au.com.riosoftware.scart.controller.response;

import au.com.riosoftware.scart.model.Product;

public class ProductResponse {

    private Long id;
    private String description;

    public ProductResponse(final Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
