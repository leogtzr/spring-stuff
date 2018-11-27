package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ToListExample1 {
    public static void main(final String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toList(5)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
