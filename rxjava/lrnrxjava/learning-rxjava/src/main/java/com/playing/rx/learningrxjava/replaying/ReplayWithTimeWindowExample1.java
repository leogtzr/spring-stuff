package com.playing.rx.learningrxjava.replaying;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ReplayWithTimeWindowExample1 {
    public static void main(final String[] args) {

        final Observable<Long> seconds = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1) * 300)            // map to elapsed milliseconds
                .replay(1, TimeUnit.SECONDS)            // only replay the last second of emissions ...
                .autoConnect()
                ;

        // Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " + l));

        SomeTools.sleepSeconds(2L);

        // Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " + l));

        SomeTools.sleepSeconds(1L);
    }
}
