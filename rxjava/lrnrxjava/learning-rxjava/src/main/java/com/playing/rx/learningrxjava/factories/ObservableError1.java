package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class ObservableError1 {
    public static void main(final String[] args) {

        Observable.error(() -> new Exception("Crash and burn!"))
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!")
                );

    }
}
