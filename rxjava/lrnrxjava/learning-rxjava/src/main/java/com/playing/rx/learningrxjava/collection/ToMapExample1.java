package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ToMapExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toMap(s -> s.charAt(0))
                .subscribe(s -> System.out.println("Received: " + s));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toMap(s -> s.charAt(0), s -> s.length())
                .subscribe(s -> System.out.println("Received: " + s));

        SomeTools.sleepSeconds(5L);

    }
}
