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
        when(mockApi.getData()).thenReturn("Mocked Database Value");

        String result = myService.fetchData();

        assertEquals("Mocked Database Value", result);
        verify(mockApi, times(1)).getData();
    }
}
