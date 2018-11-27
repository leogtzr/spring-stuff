package com.playing.rx.learningrxjava.disposing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public final class ObservableDisposal1 {

    public static void main(final String[] args) {

        final Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        final Disposable disposable = seconds.subscribe(l -> System.out.println("Received: " + l));

        SomeTools.sleepSeconds(5L);

        //dispose and stop emissions:
        disposable.dispose();

        // sleep 5 seconds to prove
        // there are no emissions
        SomeTools.sleepSeconds(5L);

        System.out.println(disposable.isDisposed());
    }

}
