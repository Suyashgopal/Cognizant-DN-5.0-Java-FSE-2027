package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public void logLevels() {
        logger.trace("Trace level");
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }

    public void logWithException(Exception ex) {
        logger.error("An error occurred", ex);
    }

    public void processData(String data) {
        logger.info("Processing data: {}", data);
        try {
            int result = Integer.parseInt(data);
            logger.debug("Parsed value: {}", result);
        } catch (NumberFormatException e) {
            logger.error("Failed to parse: {}", data, e);
        }
    }
}
