package com.playing.rx.learningrxjava.caching;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class CachingExample1 {
    public static void main(final String[] args) {
        final Observable<Integer> cachedRollingTotals = Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .scan(0, (total, next) -> total + next)
                .cache();

        cachedRollingTotals.subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }
}
