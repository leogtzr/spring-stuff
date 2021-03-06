package com.playing.rx.learningrxjava.parallel;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public final class DisposingExample1 {
    public static void main(final String[] args) {

        final Disposable d = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing on thread " + Thread.currentThread().getName()))
                .subscribe(i -> System.out.println("Received " + i))
                ;

        SomeTools.sleepSeconds(3L);
        d.dispose();
        SomeTools.sleepSeconds(3L);

    }
}
