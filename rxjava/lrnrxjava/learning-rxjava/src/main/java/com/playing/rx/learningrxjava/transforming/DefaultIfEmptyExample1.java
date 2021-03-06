package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DefaultIfEmptyExample1 {
    public static void main(final String[] args) {

        Observable.just("Leo", "Gtz", "R")
                .filter(s -> s.startsWith("Z"))
                .defaultIfEmpty("NONE")
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
