package com.testing.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void runDemo() {
        logger.trace("Trace log message");
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.warn("Warn log message");
        logger.error("Error log message");
    }
}
