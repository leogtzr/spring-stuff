package com.playing.rx.learningrxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public final class UsingJust2 {
    public static void main(final String[] args) {
        final List<String> elements = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        final Observable<String> source = Observable.fromIterable(elements);

        source
                .map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s))
                ;

    }
}
