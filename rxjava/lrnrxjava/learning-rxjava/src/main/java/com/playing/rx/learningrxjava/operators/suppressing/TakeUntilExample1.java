package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class TakeUntilExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 10)
                .takeUntil(i -> i > 5)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(3);

    }
}
