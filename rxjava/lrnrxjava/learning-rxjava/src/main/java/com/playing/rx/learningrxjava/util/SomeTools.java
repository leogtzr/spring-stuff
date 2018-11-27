package com.playing.rx.learningrxjava.util;

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

    private SomeTools() {}

}
