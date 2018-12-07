package com.playing.rx.learningrxjava.operators;

import io.reactivex.Observable;

public final class MaterializeExample1 {
    public static void main(final String[] args) {

        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source.materialize().subscribe(System.out::println);

    }
}
