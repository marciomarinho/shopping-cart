package au.com.riosoftware.scart.controller.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddItemRequestTest {

    private AddItemRequest addItemRequest;

    @Test
    public void shouldCreateNewAddItemRequest() {
        addItemRequest = new AddItemRequest(Long.valueOf(1), Long.valueOf(3), 5);
        assertEquals(addItemRequest.getShoppingCartId(), Long.valueOf(1));
        assertEquals(addItemRequest.getProductId(), Long.valueOf(3));
        assertEquals(addItemRequest.getQuantity(), 5);
    }

}