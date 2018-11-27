package com.playing.rx.learningrxjava.factories;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ObservableInterval1 {
    public static void main(final String[] args) throws InterruptedException {
        final Observable<Long> emits = Observable.interval(1, TimeUnit.SECONDS);

        // Observer 1
        emits.subscribe(lng -> System.out.println("Observer 1: " + lng));
        SomeTools.sleepSeconds(5L);

        // Observer 2
        emits.subscribe(lng -> System.out.println("Observer 2: " + lng));
        SomeTools.sleepSeconds(5L);
    }

}
