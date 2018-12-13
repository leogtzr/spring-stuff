package com.playing.rx.learningrxjava.operators;

import io.reactivex.Observable;

public final class DematerializeExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .materialize()
                .doOnNext(System.out::println)
                .dematerialize()
                .subscribe(System.out::println)
                ;

    }
}
