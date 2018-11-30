package com.playing.rx.learningrxjava.concurrency.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class SubscribeOnExample1 {
    public static void main(final String[] args) {
        final Observable<Integer> lengths = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(SomeTools::intenseCalculation)
                .map(String::length)
                .publish()
                .autoConnect(2)
                ;

        lengths.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));
        lengths.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));

        SomeTools.sleepSeconds(10L);

    }
}
