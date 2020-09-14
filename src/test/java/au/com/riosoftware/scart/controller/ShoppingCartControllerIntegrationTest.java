package au.com.riosoftware.scart.controller;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.repository.ShoppingCartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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


    @Test
    void registrationWorksThroughAllLayers() throws Exception {
        final AddItemRequest addItemRequest = new AddItemRequest(1l, 5l, 13);
        mockMvc.perform(post("/shopping-cart")
                .contentType("application/json")
//                .param("sendWelcomeMail", "true")
                .content(objectMapper.writeValueAsString(addItemRequest)))
                .andExpect(status().isOk());

//        UserEntity userEntity = userRepository.findByName("Zaphod");
//        assertThat(userEntity.getEmail()).isEqualTo("zaphod@galaxy.net");
    }

}