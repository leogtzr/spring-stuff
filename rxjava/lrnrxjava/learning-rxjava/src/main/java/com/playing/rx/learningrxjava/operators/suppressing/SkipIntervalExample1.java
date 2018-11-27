package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class SkipIntervalExample1 {
    public static void main(final String[] args) {

        Observable.interval(200, TimeUnit.MILLISECONDS)
                .skip(1, TimeUnit.SECONDS)                  // Skips the first 5 emissions.
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }

}
