package com.playing.rx.learningrxjava.windowing.time;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class TimeWindowIntervalExample1 {
    public static void main(final String[] args) {

        final Observable<Long> cutOffs = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .window(cutOffs)
                .flatMapSingle(obs -> obs.reduce("", (total, next) -> total
                        + (total.equals("") ? "" : "|") + next))
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
