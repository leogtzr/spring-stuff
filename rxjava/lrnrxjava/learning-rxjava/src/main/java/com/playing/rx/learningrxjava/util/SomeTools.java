package com.playing.rx.learningrxjava.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }

    public static <T> T intenseCalculation(final T value) {
        SomeTools.sleepSeconds(ThreadLocalRandom.current().nextInt(3_000));
        return value;
    }

    private SomeTools() {}

}
