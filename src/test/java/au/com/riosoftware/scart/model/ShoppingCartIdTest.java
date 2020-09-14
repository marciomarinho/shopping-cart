package au.com.riosoftware.scart.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ShoppingCartIdTest {

    @Mock
    private ShoppingCart shoppingCart;

    private ShoppingCartId shoppingCartId;

    @Test
    public void setup() {
        shoppingCartId = new ShoppingCartId(shoppingCart);
    }

    @Test
    public void shouldCreateShoppingCartId() {
        given(shoppingCart.getId()).willReturn(Long.valueOf(55555));
        shoppingCartId = new ShoppingCartId(shoppingCart);
        assertEquals(shoppingCartId.getId(), Long.valueOf(55555));
    }
}