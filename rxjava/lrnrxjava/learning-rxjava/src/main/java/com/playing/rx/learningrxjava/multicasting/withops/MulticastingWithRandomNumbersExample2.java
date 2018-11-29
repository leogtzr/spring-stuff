package com.playing.rx.learningrxjava.multicasting.withops;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public final class MulticastingWithRandomNumbersExample2 {

    private static int randomInt() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }

    public static void main(String[] args) {

        final ConnectableObservable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt())
                .publish();             // multicasting the streams in a single flow ...

        // Observer 1:
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));

        // Observer 2 - sum the random integer, then print
        threeRandoms.reduce(0, (total, next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        threeRandoms.connect();

        SomeTools.sleepSeconds(5L);

    }
}
