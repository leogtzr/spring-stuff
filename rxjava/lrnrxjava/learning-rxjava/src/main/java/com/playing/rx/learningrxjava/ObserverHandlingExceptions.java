package com.playing.rx.learningrxjava;

import io.reactivex.Observable;

public class ObserverHandlingExceptions {
    public static void main(final String[] args) {
        final Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");
                emitter.onNext("Delta");
                emitter.onNext("Epsilon");
                emitter.onComplete();
            } catch (final Throwable ex) {
                emitter.onError(ex);
            }
        });

        source.subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
