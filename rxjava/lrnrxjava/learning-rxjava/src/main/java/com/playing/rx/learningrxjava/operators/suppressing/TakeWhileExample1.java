package com.playing.rx.learningrxjava.operators.suppressing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class TakeWhileExample1 {

    public static void main(final String[] args) {

        Observable.range(1, 10)
                .takeWhile(i -> i < 5)
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
