package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DistinctUntilChangedExample1 {
    public static void main(final String[] args) {

        Observable.just(1, 1, 2, 2, 2, 3, 3, 2, 2, 1)
                .distinctUntilChanged()
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5);

    }
}
