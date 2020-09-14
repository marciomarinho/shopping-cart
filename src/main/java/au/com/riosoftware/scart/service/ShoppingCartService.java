package au.com.riosoftware.scart.service;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.controller.response.ShoppingCartResponse;
import au.com.riosoftware.scart.model.Product;
import au.com.riosoftware.scart.model.ShoppingCart;
import au.com.riosoftware.scart.controller.response.ShoppingCartId;
import au.com.riosoftware.scart.repository.ProductRepository;
import au.com.riosoftware.scart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartService(final ShoppingCartRepository shoppingCartRepository,
                               final ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public ShoppingCartId getShoppingCartId() {
        return new ShoppingCartId(createShoppingCart());
    }

    @Transactional
    public ShoppingCartResponse addItem(final AddItemRequest addItemRequest) {

        ShoppingCart shoppingCart = shoppingCartRepository
                .findById(addItemRequest.getShoppingCartId())
                .orElse(createShoppingCart());

        Product product = productRepository.findById(addItemRequest.getProductId()).get();

        shoppingCart.addItem(product);

        shoppingCartRepository.save(shoppingCart);

        return new ShoppingCartResponse(shoppingCart);
    }

    private ShoppingCart createShoppingCart() {
        return shoppingCartRepository.save(new ShoppingCart());
    }

}
