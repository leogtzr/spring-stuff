package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DistinctExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 10)
                .map(i -> i % 2 == 0)
                .distinct()
                .subscribe(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        SomeTools.sleepSeconds(5);

    }
}
