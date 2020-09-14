package au.com.riosoftware.scart.controller;

import au.com.riosoftware.scart.controller.request.AddItemRequest;
import au.com.riosoftware.scart.controller.response.ShoppingCartIdResponse;
import au.com.riosoftware.scart.service.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ShoppingCartControllerTest {

    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    private ShoppingCartIdResponse shoppingCartIdResponse;

    private ShoppingCartController shoppingCartController;

    @BeforeEach
    void setup() {
        shoppingCartController = new ShoppingCartController(shoppingCartService);
    }

    @Test
    void shouldGetShoppingCartId() {
        given(shoppingCartService.getShoppingCartId()).willReturn(shoppingCartIdResponse);
        shoppingCartController.getShoppingCartId();
        verify(shoppingCartService).getShoppingCartId();
    }

    @Test
    void shouldAddItem() {
        final AddItemRequest addItemRequest = new AddItemRequest(1l, 5l, 13);
        shoppingCartController.addItem(addItemRequest);
        verify(shoppingCartService).addItem(addItemRequest);
    }

}