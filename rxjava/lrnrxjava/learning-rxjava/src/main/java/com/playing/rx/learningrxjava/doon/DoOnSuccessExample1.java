package com.playing.rx.learningrxjava.doon;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DoOnSuccessExample1 {
    public static void main(final String[] args) {

        Observable.just(5, 3, 7, 10, 2, 14)
                .reduce((total, next) -> total + next)
                .doOnSuccess(i -> System.out.println("Emitting: " + i))
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        SomeTools.sleepSeconds(5L);

    }
}
