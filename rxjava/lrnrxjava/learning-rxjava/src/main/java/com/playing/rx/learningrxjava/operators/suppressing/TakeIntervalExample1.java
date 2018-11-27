package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class TakeIntervalExample1 {
    public static void main(final String[] args) {

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }

}
