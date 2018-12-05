package com.playing.rx.learningrxjava.customops;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;

public final class ImplementingObservableOperatorExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 5)
                .lift(doOnEmpty(() -> System.out.println("Operation 1 Empty!")))
                .subscribe(v -> System.out.println("Operation 1: " + v))
        ;

        System.out.println("~~~~~~~~~~~~~");

        Observable.empty()
                .lift(doOnEmpty(() -> System.out.println("Operation 2 Empty!")))
                .subscribe(v -> System.out.println("Operation 2: " + v));
    }

    private static <T> ObservableOperator<T, T> doOnEmpty(final Action action) {
        return observer -> new DisposableObserver<T>() {

            private boolean isEmpty = true;

            @Override
            public void onNext(final T value) {
                this.isEmpty = false;
                observer.onNext(value);
            }

            @Override
            public void onError(final Throwable throwable) {
                observer.onError(throwable);
            }

            @Override
            public void onComplete() {
                if (this.isEmpty) {
                    try {
                        action.run();
                    } catch (final Exception ex) {
                        onError(ex);
                        return;
                    }
                }
                observer.onComplete();
            }
        };
    }
}
