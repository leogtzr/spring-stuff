package com.playing.rx.learningrxjava.factories;

import com.playing.rx.learningrxjava.util.SomeTools;
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
        SomeTools.sleepSeconds(5L);

        // Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " + l));
        SomeTools.sleepSeconds(5L);

    }

}
