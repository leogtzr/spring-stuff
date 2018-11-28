package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.HashSet;

public final class CollectSetExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                // for tricker cases ...
                .collect(HashSet::new, HashSet::add)
                .subscribe(s -> System.out.println("Received: " + s))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
