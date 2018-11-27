package com.playing.rx.learningrxjava.operators.suppressing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class SkipIntervalExample1 {
    public static void main(final String[] args) {

        Observable.interval(200, TimeUnit.MILLISECONDS)
                .skip(1, TimeUnit.SECONDS)                  // Skips the first 5 emissions.
                .subscribe(System.out::println);

        sleep(TimeUnit.SECONDS.toMillis(5L));
    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
