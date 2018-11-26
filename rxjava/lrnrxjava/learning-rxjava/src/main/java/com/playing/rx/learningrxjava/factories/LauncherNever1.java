package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class LauncherNever1 {
    public static void main(final String[] args) {
        final Observable<String> empty = Observable.never();
        empty.subscribe(
                System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done!")
        );

    }
}
