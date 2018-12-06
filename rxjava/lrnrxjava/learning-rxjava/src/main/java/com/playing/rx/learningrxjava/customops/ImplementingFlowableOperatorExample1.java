package com.playing.rx.learningrxjava.customops;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.functions.Action;
import io.reactivex.subscribers.DisposableSubscriber;

public final class ImplementingFlowableOperatorExample1 {

    public static void main(String[] args) {
        Flowable.range(1, 5)
                .lift(doOnEmpty(() -> System.out.println("Operation 1 Empty!")))
                .subscribe(v -> System.out.println("Operation 1: " + v));

        Flowable.<Integer>empty()
                .lift(doOnEmpty(() -> System.out.println("Operation 2 Empty!")))
                .subscribe(v -> System.out.println("Operation 2: " + v));
    }

    private static <T> FlowableOperator<T, T> doOnEmpty(final Action action) {
        return subscriber -> new DisposableSubscriber<T>() {

            private boolean isEmpty = true;

            @Override
            public void onNext(final T value) {
                this.isEmpty = false;
                subscriber.onNext(value);
            }

            @Override
            public void onError(final Throwable throwable) {
                subscriber.onError(throwable);
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
                subscriber.onComplete();
            }
        };
    }

}
