package com.playing.rx.learningrxjava.parallel;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public final class GroupByExample1 {
    public static void main(final String[] args) {

        final int coreCount =  Runtime.getRuntime().availableProcessors();
        final AtomicInteger assigner = new AtomicInteger(0);

        Observable.range(1, 10)
                .groupBy(i -> assigner.incrementAndGet() % coreCount)
                .flatMap(grp -> grp.observeOn(Schedulers.io())
                        .map(i2 -> SomeTools.intenseCalculation(i2))
                ).subscribe(i -> System.out.println("Received " + i + " " + LocalTime.now() + " on thread " + Thread.currentThread().getName()))
                ;

        SomeTools.sleepSeconds(20L);

    }
}
