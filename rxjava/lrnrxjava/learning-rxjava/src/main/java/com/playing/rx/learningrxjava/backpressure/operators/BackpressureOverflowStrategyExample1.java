package com.playing.rx.learningrxjava.backpressure.operators;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public final class BackpressureOverflowStrategyExample1 {
    public static void main(final String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS.MILLISECONDS)
                .onBackpressureBuffer(10, () -> System.out.println("Overflow!"), BackpressureOverflowStrategy.DROP_LATEST)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    SomeTools.sleep(5L);
                    System.out.println(i);
                });

        SomeTools.sleepSeconds(5L);
    }
}
