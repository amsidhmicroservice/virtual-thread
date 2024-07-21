package com.amsidh.mvc.util;

import java.time.Duration;

public class CommonUtil {

    public static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
    }

    public static long timer(Runnable runnable) {
        var startTime = System.currentTimeMillis();
        runnable.run();
        var endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
