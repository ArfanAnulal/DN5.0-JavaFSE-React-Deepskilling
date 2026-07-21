package com.junit.test.stubbing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoreProcessorTest {

    @Test
    public void testMockingAndStubbing() {
        // Exercise 1: Mocking and Stubbing
        DataService mockService = Mockito.mock(DataService.class);
        
        // Stubbing the pullPayload method
        when(mockService.pullPayload()).thenReturn("Simulated Payload");
        
        CoreProcessor processor = new CoreProcessor(mockService);
        String output = processor.load();
        
        assertEquals("Simulated Payload", output, "The load method should return the stubbed data.");
    }

    @Test
    public void testVerifyingInteractions() {
        // Exercise 2: Verifying Interactions
        DataService mockService = Mockito.mock(DataService.class);
        CoreProcessor processor = new CoreProcessor(mockService);
        
        // Trigger the logic
        processor.load();
        
        // Verify that pullPayload was called on the mock object
        verify(mockService).pullPayload();
    }
}
