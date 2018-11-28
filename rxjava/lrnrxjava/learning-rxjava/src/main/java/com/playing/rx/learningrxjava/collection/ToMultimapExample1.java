package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ToMultimapExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toMultimap(String::length)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
