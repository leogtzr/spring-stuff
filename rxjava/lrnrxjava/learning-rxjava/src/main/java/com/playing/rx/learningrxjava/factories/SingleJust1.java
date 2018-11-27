package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;
import io.reactivex.Single;

public final class SingleJust1 {
    public static void main(final String[] args) {

        Single.just("Hello")
                .map(String::length)
                .subscribe(System.out::println,
                        Throwable::printStackTrace
                        );

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
        source.first("alrpvw")
                .map(String::toUpperCase)
                .subscribe(System.out::println);

    }
}
