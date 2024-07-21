package com.amsidh.mvc.sec02;

import com.amsidh.mvc.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {

    private static final Logger log = LoggerFactory.getLogger(Task.class);

    public static void cpuIntensive(int i) {
        log.info("starting CPU task {}. Thread Info {}", i, Thread.currentThread());
        final long timer = CommonUtil.timer(() -> findFib(i));
        log.info("Ending CPU task {}. Thread Info {} and time taken {}", i, Thread.currentThread(), timer);
    }

    public static long findFib(long input) {
        if (input < 2)
            return input;
        return findFib(input - 1) + findFib(input - 2);
    }
}
