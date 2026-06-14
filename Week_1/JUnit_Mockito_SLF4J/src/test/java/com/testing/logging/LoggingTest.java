package com.testing.logging;

import org.junit.jupiter.api.Test;

public class LoggingTest {
    @Test
    public void testLoggingExecution() {
        LoggingService service = new LoggingService();
        service.runDemo();
    }
}
