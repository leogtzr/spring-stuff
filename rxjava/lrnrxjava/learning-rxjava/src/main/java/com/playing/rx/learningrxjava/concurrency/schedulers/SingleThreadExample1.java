package com.playing.rx.learningrxjava.concurrency.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class SingleThreadExample1 {
    public static void main(final String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.single())
                .map(SomeTools::intenseCalculation)
                .subscribe(System.out::println)
                ;

    }
}
