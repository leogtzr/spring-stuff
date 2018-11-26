package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class ObservableEmpty1 {
    public static void main(final String[] args) {

        // No emissions!
        Observable.empty()
                .subscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}
