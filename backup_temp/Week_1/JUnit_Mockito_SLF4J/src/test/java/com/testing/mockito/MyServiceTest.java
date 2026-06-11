package com.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    @InjectMocks
    private MyService myService;

    @Test
    public void testFetchDataStubbing() {
        // Exercise 1: Mocking and Stubbing
        when(mockApi.getData()).thenReturn("Mocked Database Value");

        String result = myService.fetchData();

        assertEquals("Mocked Database Value", result);
        verify(mockApi, times(1)).getData(); // Exercise 2: Verifying Interactions
    }

    @Test
    public void testSaveDataInteraction() {
        // Exercise 4: Handling Void Methods
        doNothing().when(mockApi).updateData("config.key", "config.val");

        myService.saveData("config.key", "config.val");

        verify(mockApi).updateData("config.key", "config.val");
    }

    @Test
    public void testMultipleReturns() {
        // Exercise 5: Mocking and Stubbing with Multiple Returns
        when(mockApi.getData()).thenReturn("First Call", "Second Call");

        assertEquals("First Call", myService.fetchData());
        assertEquals("Second Call", myService.fetchData());
    }

    @Test
    public void testArgumentMatching() {
        // Exercise 3: Argument Matching
        when(mockApi.getValueFor(anyString())).thenReturn("Matched Value");

        assertEquals("Matched Value", myService.getValue("anyKey"));
        assertEquals("Matched Value", myService.getValue("anotherKey"));
    }

    @Test
    public void testVoidMethodWithException() {
        // Exercise 7: Handling Void Methods with Exceptions
        doThrow(new RuntimeException("Database Connection Failure"))
            .when(mockApi).updateData(eq("restrictedKey"), anyString());

        assertThrows(RuntimeException.class, () -> {
            myService.saveData("restrictedKey", "testVal");
        });
    }

    @Test
    public void testInteractionOrder() {
        // Exercise 6: Verifying Interaction Order
        when(mockApi.getData()).thenReturn("data");
        
        myService.fetchData();
        myService.saveData("key", "val");

        var inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).updateData("key", "val");
    }
}
