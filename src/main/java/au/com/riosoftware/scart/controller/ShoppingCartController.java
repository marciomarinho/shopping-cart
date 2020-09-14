package au.com.riosoftware.scart.controller;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.controller.response.ShoppingCartResponse;
import au.com.riosoftware.scart.controller.response.ShoppingCartId;
import au.com.riosoftware.scart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(final ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCartId> getShoppingCartId() {
        return new ResponseEntity<>(shoppingCartService.getShoppingCartId(), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<ShoppingCartResponse> addItem(@RequestBody final AddItemRequest addItemRequest) {
        ShoppingCartResponse shoppingCartResponse = this.shoppingCartService.addItem(addItemRequest);
        return new ResponseEntity<>(shoppingCartResponse, HttpStatus.OK);
    }

}
