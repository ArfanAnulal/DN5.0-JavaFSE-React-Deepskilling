package com.junit.test.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLoggerService {
    private static final Logger logger = LoggerFactory.getLogger(AppLoggerService.class);

    public void performTask(String parameter) {
        logger.info("Executing task with parameter: {}", parameter);
        
        if (parameter == null) {
            logger.warn("Parameter is null! Falling back to default settings.");
            parameter = "default";
        }

        try {
            if ("error-trigger".equals(parameter)) {
                throw new RuntimeException("Simulated processing error.");
            }
            logger.debug("Task completed successfully for value: {}", parameter);
        } catch (Exception e) {
            logger.error("An unexpected error occurred during execution: {}", e.getMessage());
        }
    }
}
