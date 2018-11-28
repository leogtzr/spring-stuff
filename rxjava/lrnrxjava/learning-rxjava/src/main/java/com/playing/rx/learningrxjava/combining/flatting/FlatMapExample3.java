package com.playing.rx.learningrxjava.combining.flatting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class FlatMapExample3 {
    public static void main(final String[] args) {

        final Observable<Integer> intervalArguments = Observable.just(2, 3, 10, 7);
//        intervalArguments.flatMap(i ->
//                Observable.interval(i, TimeUnit.SECONDS)
//                .map(i2 -> i + "s interval: " + ((i + 1) * i) + " seconds elapsed")
//        ).subscribe(System.out::println);
        intervalArguments.flatMap(i ->
                Observable.interval(i, TimeUnit.SECONDS)
                        .map(i2 -> i + "s interval: " + ((i + 1) * i) + " seconds elapsed")
                        ).subscribe(System.out::println);

        SomeTools.sleepSeconds(15L);

    }
}
