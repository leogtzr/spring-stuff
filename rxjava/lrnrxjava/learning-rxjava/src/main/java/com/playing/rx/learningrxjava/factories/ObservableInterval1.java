package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ObservableInterval1 {
    public static void main(final String[] args) throws InterruptedException {
        final Observable<Long> emits = Observable.interval(1, TimeUnit.SECONDS);

        // Observer 1
        emits.subscribe(lng -> System.out.println("Observer 1: " + lng));
        sleep(5000);
        //Thread.sleep(TimeUnit.MILLISECONDS.toSeconds(5000));

        // Observer 2
        emits.subscribe(lng -> System.out.println("Observer 2: " + lng));
        sleep(5000);
        //Thread.sleep(TimeUnit.MILLISECONDS.toSeconds(5000));
    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
