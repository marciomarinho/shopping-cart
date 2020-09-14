package au.com.riosoftware.scart.controller;

import au.com.riosoftware.scart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    private ProductController productController;

    @BeforeEach
    void setup() {
        this.productController = new ProductController(productService);
    }

    @Test
    void shouldGetProducts() {
        productController.getProducts();
        verify(this.productService).getProducts();
    }
}