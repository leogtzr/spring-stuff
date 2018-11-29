package com.playing.rx.learningrxjava.replaying;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ReplyExample1 {
    public static void main(final String[] args) {
        final Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();

        // Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " + l));

        SomeTools.sleepSeconds(3L);

        // Observer 2
        seconds.subscribe(l -> System.out.println("\tObserver 2: " + l));

        SomeTools.sleepSeconds(3L);
    }
}
