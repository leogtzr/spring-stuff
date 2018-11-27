package com.playing.rx.learningrxjava.disposing;

import io.reactivex.Observable;

public final class ObservableEmitter1 {
    public static void main(final String[] args) {

        final Observable<Integer> source = Observable.create( observableEmitter -> {
            try {

                for (int i = 0; i < 1000; i++) {
                    while (!observableEmitter.isDisposed()) {
                        observableEmitter.onNext(i);
                    }
                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                }

                observableEmitter.onComplete();
            } catch (final Throwable ex) {
                observableEmitter.onError(ex);
            }
        }
        );

    }
}
