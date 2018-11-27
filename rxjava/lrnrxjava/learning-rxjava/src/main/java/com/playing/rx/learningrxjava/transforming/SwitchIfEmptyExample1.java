package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class SwitchIfEmptyExample1 {
    public static void main(final String[] args) {
        Observable.just("Leo", "Gtz", "R")
                .filter(s -> s.startsWith("X"))
        .switchIfEmpty(Observable.just("A", "B", "C"))
                .subscribe(i -> System.out.println("Received: " + i));

        SomeTools.sleepSeconds(5L);
    }
}
