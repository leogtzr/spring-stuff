package com.playing.rx.learningrxjava.concurrency;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class ConcurrencyExample3 {
    public static void main(final String[] args) {

        // With subscribeOn() emissions are executed in a separate thread.
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(s -> SomeTools.intenseCalculation(s))
                .subscribe(System.out::println)
                ;

        // With subscribeOn() emissions are executed in a separate thread.
        Observable.range(1, 6)
                .subscribeOn(Schedulers.computation())
                .map(x -> SomeTools.intenseCalculation(x))
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(20L, () -> "waiting");

    }
}
