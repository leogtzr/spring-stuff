package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.ConcurrentHashMap;

public class ToMapExample2 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toMap(s -> s.charAt(0), String::length, ConcurrentHashMap::new)
                .subscribe(s -> System.out.println("Received: " + s));

        SomeTools.sleepSeconds(5L);
    }
}
