package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ReduceExample1 {
    public static void main(final String[] args) {

        Observable.just(2, 4, 3)
                .reduce((acc, x) -> acc + x).subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
