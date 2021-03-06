package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ContainsExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 10)
                .contains(4)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
