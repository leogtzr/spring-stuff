package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.CopyOnWriteArrayList;

public final class ToListExample2 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        .toList(CopyOnWriteArrayList::new)
        .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
    }
}
