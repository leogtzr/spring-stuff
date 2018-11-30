package com.playing.rx.learningrxjava.concurrency;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ConcurrencyExample1 {
    public static void main(final String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + " Mississippi")
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
    }
}
