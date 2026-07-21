package com.junit.test.logging;

import org.junit.jupiter.api.Test;

public class AppLoggerTest {
    @Test
    public void testLoggingBehaviors() {
        AppLoggerService service = new AppLoggerService();
        service.performTask(null);
        service.performTask("error-trigger");
    }
}
