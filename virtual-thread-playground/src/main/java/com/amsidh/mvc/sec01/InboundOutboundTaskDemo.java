package com.amsidh.mvc.sec01;

import java.util.concurrent.CountDownLatch;

public class InboundOutboundTaskDemo {
    private static final Integer MAX_PLATFORM_THREAD = 10;
    private static final Integer MAX_VIRTUAL_THREAD = 20;

    public static void main(String[] args) {
        //platformThreadDemo1();
        virtualThreadDemo1();
    }

    public static void platformThreadDemo1() {
        for (int i = 0; i < MAX_PLATFORM_THREAD; i++) {
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    public static void platformThreadDemo2() {
        var builder = Thread.ofPlatform()
                .name("amsidh", 1);
        for (int i = 0; i < MAX_PLATFORM_THREAD; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    public static void platformThreadDemo3() {
        var latch = new CountDownLatch(3);
        var builder = Thread.ofPlatform()
                .daemon()
                .name("amsidh", 1);
        for (int i = 0; i < MAX_PLATFORM_THREAD; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void virtualThreadDemo1() {
        var latch = new CountDownLatch(MAX_VIRTUAL_THREAD);
        var builder = Thread.ofVirtual()
                .name("amsidh", 1);
        for (int i = 0; i < MAX_VIRTUAL_THREAD; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
       try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
