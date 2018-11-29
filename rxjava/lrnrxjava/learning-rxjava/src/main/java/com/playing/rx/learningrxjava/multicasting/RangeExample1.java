package com.playing.rx.learningrxjava.multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public final class RangeExample1 {
    public static void main(final String[] args) {

        final ConnectableObservable<Integer> threeIntegers = Observable.range(1, 3).publish();

        threeIntegers.subscribe(i -> System.out.println("Observer one: " + i));
        threeIntegers.subscribe(i -> System.out.println("Observer two: " + i));

        threeIntegers.connect();

    }
}
