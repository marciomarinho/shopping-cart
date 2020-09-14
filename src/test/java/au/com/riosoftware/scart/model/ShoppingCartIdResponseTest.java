package au.com.riosoftware.scart.model;

import au.com.riosoftware.scart.controller.response.ShoppingCartIdResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ShoppingCartIdResponseTest {

    @Mock
    private ShoppingCart shoppingCart;

    private ShoppingCartIdResponse shoppingCartIdResponse;

    @Test
    public void setup() {
        shoppingCartIdResponse = new ShoppingCartIdResponse(shoppingCart);
    }

    @Test
    public void shouldCreateShoppingCartId() {
        given(shoppingCart.getId()).willReturn(Long.valueOf(55555));
        shoppingCartIdResponse = new ShoppingCartIdResponse(shoppingCart);
        assertEquals(shoppingCartIdResponse.getId(), Long.valueOf(55555));
    }
}