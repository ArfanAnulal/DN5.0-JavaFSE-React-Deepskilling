package com.testing.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void runDemo() {
        // Exercise 1: Logging Error Messages and Warning Levels
        logger.trace("Trace log message");
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.warn("Warn log message");
        logger.error("Error log message");
    }

    public void processUserAction(String username, String action, int actionId) {
        // Exercise 2: Parameterized Logging
        logger.info("User '{}' performed action '{}' with transaction reference #{}", username, action, actionId);
    }
}
