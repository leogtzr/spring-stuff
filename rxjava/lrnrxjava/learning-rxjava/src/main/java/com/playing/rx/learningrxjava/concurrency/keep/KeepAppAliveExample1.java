package com.playing.rx.learningrxjava.concurrency.keep;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class KeepAppAliveExample1 {
    public static void main(final String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(SomeTools::intenseCalculation)
                .blockingSubscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done!"));

    }
}
