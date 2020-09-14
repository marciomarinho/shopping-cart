package au.com.riosoftware.scart.service;

import au.com.riosoftware.scart.model.Product;
import au.com.riosoftware.scart.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        productService = new ProductService(productRepository);
    }

    @Test
    public void shouldReturnListOfProducts() {
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("abcdef", new BigDecimal("55.326779464").setScale(2, RoundingMode.HALF_UP)));
        expected.add(new Product("azzzzz", new BigDecimal("19.9876").setScale(2, RoundingMode.HALF_UP)));
        expected.add(new Product("398gjhhf", new BigDecimal("68.577563883").setScale(2, RoundingMode.HALF_UP)));
        given(productRepository.findAll()).willReturn(expected);
        List<Product> actual = productService.getProducts();
        assertEquals(expected, actual);
        verify(productRepository).findAll();
    }
}