package com.testing.logging;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class LoggingTest {
    @Test
    public void testLoggingExecution() {
        LoggingService service = new LoggingService();
        
        // Execute demo to trigger Logback printing
        service.runDemo();
        service.processUserAction("johndoe", "PAY_LOAN", 12345);

        // Check if log file 'app.log' is created by FileAppender (Exercise 3)
        File logFile = new File("app.log");
        assertTrue(logFile.exists(), "Logfile 'app.log' should have been created by FileAppender");
    }
}
