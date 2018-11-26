package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ObservableInterval1 {
    public static void main(final String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
    }
}
