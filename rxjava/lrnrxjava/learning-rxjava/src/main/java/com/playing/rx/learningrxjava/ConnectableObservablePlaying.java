package com.playing.rx.learningrxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public final class ConnectableObservablePlaying {
    public static void main(final String[] args) {
        final ConnectableObservable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .publish();

        // Set up observer 1
        source.subscribe(s -> System.out.println("Observer 1: " + s));

        // Set up observer 2
        source.map(String::length)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        // Fire!
        source.connect();
    }
}
