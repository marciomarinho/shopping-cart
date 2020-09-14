package au.com.riosoftware.scart.controller;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.model.Product;
import au.com.riosoftware.scart.model.ShoppingCart;
import au.com.riosoftware.scart.repository.ProductRepository;
import au.com.riosoftware.scart.repository.ShoppingCartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.AdditionalMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ShoppingCartControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;


    @Test
    void shouldAddProductsToTheShoppingCartStep1() throws Exception {

        final MvcResult mvcResult = mockMvc.perform(
                post("/shopping-cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andReturn();

        final Map<String, Integer> cartMap = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Map.class);

        final Product doveSoap = productRepository.findByDescription("Dove Soap");

        final Long cartId = Long.valueOf(cartMap.get("id"));
        final AddItemRequest addItemRequest = new AddItemRequest(cartId, doveSoap.getId(), 1);

        for (int i = 0; i < 5; i++) {
            mockMvc.perform(
                    patch("/shopping-cart")
                            .content(objectMapper.writeValueAsString(addItemRequest))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        }

        final ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId).get();
        assertThat(shoppingCart.getTotal(), is(new BigDecimal("199.95")));

    }

}