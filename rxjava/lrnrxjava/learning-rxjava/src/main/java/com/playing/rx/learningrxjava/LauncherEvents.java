package com.playing.rx.learningrxjava;

import io.reactivex.Observable;

public class LauncherEvents {
    public static void main(final String[] args) {
        final Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onNext("Delta");
            emitter.onNext("Epsilon");
            emitter.onComplete();
        });

        source.subscribe(s -> System.out.println("RECEIVED: " + s));

    }
}
