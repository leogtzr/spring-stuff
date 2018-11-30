package com.playing.rx.learningrxjava.concurrency;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public final class ConcurrencyExample4 {
    public static void main(final String[] args) {
        // With subscribeOn() emissions are executed in a separate thread.
        final Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(s -> SomeTools.intenseCalculation(s))
                ;

        // With subscribeOn() emissions are executed in a separate thread.
        final Observable<Integer> source2 = Observable.range(1, 6)
                .subscribeOn(Schedulers.computation())
                .map(x -> SomeTools.intenseCalculation(x));
        ;

        Observable.zip(source1, source2, (s,i) -> s + "-" + i)
                .subscribe(System.out::println)
        ;

        SomeTools.sleepSeconds(20L);
    }
}
