package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public final class LauncherConnectableObservable1 {
    public static void main(final String[] args) {
        final ConnectableObservable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).publish();

        // Cold emissions ...

        // Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " + l));
        seconds.connect();

        // sleep 5 seconds:
        sleep(5000);

        // Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " + l));
        sleep(5000);


    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
