package com.playing.rx.learningrxjava.concurrency.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public final class IntervalSchedulerExample1 {
    public static void main(final String[] args) {

        Observable.interval(1, TimeUnit.SECONDS, Schedulers.newThread())
                .subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()))
                ;

        SomeTools.sleepSeconds(5L);

    }
}
