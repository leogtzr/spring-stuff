package com.playing.rx.learningrxjava.concurrency;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ConcurrencyExample2 {
    public static void main(String[] args) {

        // All these operations are executed in the main thread ...

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .map(s -> SomeTools.intenseCalculation(s))
                .subscribe(System.out::println);

        Observable.range(1, 6)
                .map(x -> SomeTools.intenseCalculation(x))
                .subscribe(System.out::println)
                ;
    }
}
