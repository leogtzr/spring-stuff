package com.playing.rx.learningrxjava;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Launcher {
    public static void main(final String[] args) {
        final Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);
        secondIntervals.subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }

}
