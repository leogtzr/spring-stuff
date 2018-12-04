package com.playing.rx.learningrxjava.backpressure.conversion;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class ToObservableExample1 {
    public static void main(final String[] args) {
        final Flowable<Integer> integers = Flowable.range(1, 1_000)
                .subscribeOn(Schedulers.computation());

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .flatMap(s -> integers.map(i -> i + " - " + s).toObservable())
                .subscribe(System.out::println)
                ;

        SomeTools.sleep(5L);

    }
}
