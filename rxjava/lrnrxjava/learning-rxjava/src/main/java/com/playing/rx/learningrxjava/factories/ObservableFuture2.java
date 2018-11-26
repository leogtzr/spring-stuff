package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class ObservableFuture2 {

    private static ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    public static void main(final String[] args) {

        final Future<Double> nextRandomValue = randomValue();
        Observable.fromFuture(nextRandomValue)
                .map(x -> x * 10.0D)
                // It will pull out the value when available ... 
                .subscribe(System.out::println);

        EXECUTOR.shutdown();

    }

    private static Future<Double> randomValue() {
        return EXECUTOR.submit(() -> Math.random());
    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
