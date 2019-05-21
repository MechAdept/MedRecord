package com.samsolutions.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    public void logMessages() {
        logger.debug("debug"); // all
        logger.info("info"); // except debug
        logger.warn("warn"); // except debug and info
        logger.error("error"); // except debug, info and warn
    }
}