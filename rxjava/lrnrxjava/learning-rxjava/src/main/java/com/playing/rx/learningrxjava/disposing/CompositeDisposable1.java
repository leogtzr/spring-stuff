package com.playing.rx.learningrxjava.disposing;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public final class CompositeDisposable1 {

    private static final CompositeDisposable DISPOSABLES = new CompositeDisposable();

    public static void main(final String[] args) {
        final Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        // Subscribe and capture disposables:
        final Disposable disposable1 = seconds.subscribe(l -> System.out.println("Observer 1: " + l));
        final Disposable disposable2 = seconds.subscribe(l -> System.out.println("Observer 2: " + l));

        // put both disposables into CompositeDisposables:
        DISPOSABLES.addAll(disposable1, disposable2);

        sleep(TimeUnit.SECONDS.toMillis(5L));

        // dispose all disposables when we no longer want to be subscribed to ...
        DISPOSABLES.dispose();

        // sleep 5 more seconds to prove that there are no more emissions:
        sleep(TimeUnit.SECONDS.toMillis(5L));
    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
