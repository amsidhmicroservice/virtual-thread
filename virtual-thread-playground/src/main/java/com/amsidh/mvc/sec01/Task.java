package com.amsidh.mvc.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Task {

    private static final Logger log = LoggerFactory.getLogger(Task.class);

    public static void ioIntensive(int i) {
        try {
            log.info("Starting I/O task for {} and Thread detail {}", i, Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(10));
            log.info("Ending I/O task for {} and Thread detail {}", i, Thread.currentThread());
        } catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
    }
}
