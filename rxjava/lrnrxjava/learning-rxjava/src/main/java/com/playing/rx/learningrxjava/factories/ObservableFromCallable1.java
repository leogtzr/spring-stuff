package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class ObservableFromCallable1 {
    public static void main(final String[] args) {

        // The following code would cause the main thread to stop ...
        // It would be propagated to the main thread and it would blow up ...

//        Observable.just(1 / 0)
//                .subscribe(i -> System.out.println("RECEIVED: " + i), e -> System.out.println("Error captured: " + e));

        Observable.fromCallable(() -> (1 / 0))
                .subscribe(i -> System.out.println("RECEIVED: " + i), e -> System.out.println("Error captured: " + e));

        System.out.println("Bye ... ");
    }
}
