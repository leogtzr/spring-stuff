package com.playing.rx.learningrxjava.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public final class SomeTools {

    public static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void sleepSeconds(final long seconds) {
        sleep(TimeUnit.SECONDS.toMillis(seconds));
    }

    public static void sleepSeconds(final long seconds, final Supplier<String> supStr) {
        System.out.println(supStr.get());
        sleepSeconds(seconds);
    }

    public static void sleepMillis(final long millis) {
        sleep(millis);
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }

    public static <T> T intenseCalculation(final T value) {
        sleepMillis(ThreadLocalRandom.current().nextInt(3_000));
        return value;
    }

    public static int randomSleepTime() {
        return ThreadLocalRandom.current().nextInt(2000);
    }

    private SomeTools() {}

}
