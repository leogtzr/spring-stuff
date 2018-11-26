package com.playing.rx.learningrxjava;

import io.reactivex.Observable;

public final class ColdObservables1 {
    public static void main(final String[] args) {
        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        // First observer:
        source.subscribe(s -> System.out.println("Observer 1 received: " + s));

        // Second observer:
        // This second observer
        source.map(String::toUpperCase).subscribe(s -> System.out.println("Observer 2 received: " + s));
    }
}
