package com.playing.rx.learningrxjava.operators.suppressing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class TakeLastExample1 {
    public static void main(final String[] args) {

        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .takeLast(2)            // takes 8 and 9
                .subscribe(System.out::println)
                ;

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
