package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class AnyExample1 {
    public static void main(final String[] args) {

        Observable.just(5, 7, 2)
                .any(x -> x % 2 == 0)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
