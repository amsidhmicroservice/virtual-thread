package com.amsidh.mvc.sec02;

import java.util.concurrent.CountDownLatch;

public class CPUTaskDemo {
    private static final int TASK_COUNT = 3 * Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        var platformThread = Thread.ofPlatform();
        platformThread.name("Platform-", 1);
        var virtualThread = Thread.ofVirtual();
        virtualThread.name("Virtual-", 1);

        //demo(platformThread);
        demo(virtualThread);

    }

    public static void demo(Thread.Builder builder) {
        var latch = new CountDownLatch(TASK_COUNT);
        for (int i = 1; i <= TASK_COUNT; i++) {
            builder.start(() -> {
                Task.cpuIntensive(45);
                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
