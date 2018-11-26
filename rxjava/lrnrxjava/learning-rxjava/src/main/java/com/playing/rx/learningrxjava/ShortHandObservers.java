package com.playing.rx.learningrxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public final class ShortHandObservers {
    public static void main(String[] args) {
        final Consumer<Integer> onNext = i -> System.out.println("Received: " + i);
        final Action onComplete = () -> System.out.println("Done!");
        final Consumer<Throwable> onError = Throwable::printStackTrace;

        final Observable<String> source = Observable.just("Leo", "Brenda", "Edgar", "Edgar", "María");

        source
                .map(String::length)
                .filter(i -> i >= 5)
                .subscribe(onNext, onError, onComplete)
                ;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        final Observable<String> source2 = Observable.just("Leo", "Brenda", "Edgar", "Edgar", "María");
        source2
                .map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("REC: " + s),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!")
                );

    }
}
