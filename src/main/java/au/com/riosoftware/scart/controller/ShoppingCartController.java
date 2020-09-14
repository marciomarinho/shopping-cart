package au.com.riosoftware.scart.controller;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.controller.response.ShoppingCartResponse;
import au.com.riosoftware.scart.model.ShoppingCartId;
import au.com.riosoftware.scart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(final ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ShoppingCartId getShoppingCartId() {
        return shoppingCartService.getShoppingCartId();
    }

    @PatchMapping
    public ShoppingCartResponse addItem(@RequestBody final AddItemRequest addItemRequest) {
        ShoppingCartResponse shoppingCartResponse = this.shoppingCartService.addItem(addItemRequest);
        return shoppingCartResponse;
    }

}
