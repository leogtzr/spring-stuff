package com.playing.rx.learningrxjava.parallel;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;

public final class ParallelExample1 {
    public static void main(final String[] args) {

        // Slow ...
//        Observable.range(1, 10)
//                .map(i -> SomeTools.intenseCalculation(i))
//                .subscribe(i -> System.out.println("Received " + i + " " + LocalTime.now()))
//                ;

        Observable.range(1, 10)
                .flatMap(i -> Observable.just(i)
                        .subscribeOn(Schedulers.computation())
                        .map(i2 -> SomeTools.intenseCalculation(i2))
                ).
                subscribe(i -> System.out.println("Received " + i + " "
                + LocalTime.now() + " on thread "
                + Thread.currentThread().getName()));

        SomeTools.sleepSeconds(20L);

    }
}
