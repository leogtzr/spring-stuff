package com.playing.rx.learningrxjava.concurrency.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ExecutorServiceExample1 {
    public static void main(final String[] args) {

        final int numberOfThreads = 20;

        final ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        final Scheduler scheduler = Schedulers.from(executor);

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(scheduler)
                .map(s -> System.out.printf("%s by %s", s, Thread.currentThread().getName()))
                .doFinally(executor::shutdown)
                .subscribe(System.out::println)
        ;
    }
}
