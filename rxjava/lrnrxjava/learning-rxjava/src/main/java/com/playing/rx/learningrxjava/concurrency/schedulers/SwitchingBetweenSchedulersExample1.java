package com.playing.rx.learningrxjava.concurrency.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class SwitchingBetweenSchedulersExample1 {
    public static void main(final String[] args) {

        Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO", "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))

                // Happens on Computation Scheduler
        .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce((total, next) -> total+next)
                .subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()))
                ;

        SomeTools.sleepSeconds(1L);

    }
}
