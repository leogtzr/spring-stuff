package com.playing.rx.learningrxjava.disposing;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public final class ObservableDisposal1 {

    public static void main(final String[] args) {

        final Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        final Disposable disposable = seconds.subscribe(l -> System.out.println("Received: " + l));

        sleep(5_000L);

        //dispose and stop emissions:
        disposable.dispose();

        // sleep 5 seconds to prove
        // there are no emissions
        sleep(5_000L);

        System.out.println(disposable.isDisposed());
    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
