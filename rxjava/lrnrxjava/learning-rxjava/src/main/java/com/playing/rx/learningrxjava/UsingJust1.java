package com.playing.rx.learningrxjava;

import io.reactivex.Observable;

public final class UsingJust1 {
    public static void main(final String[] args) {
        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        source
                .map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
