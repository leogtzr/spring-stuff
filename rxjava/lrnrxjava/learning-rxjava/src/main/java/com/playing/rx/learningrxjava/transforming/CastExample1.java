package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class CastExample1 {
    public static void main(final String[] args) {

        Observable<Object> items = Observable.just("Leo", "Gtz", "Ramirez")
                .cast(Object.class);

        items.subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}