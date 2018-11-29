package com.playing.rx.learningrxjava.replaying;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ReplySingleEmissionExample1 {
    public static void main(final String[] args) {
        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .replay(1)
                .autoConnect();

        // Observer 1
        source.subscribe(l -> System.out.println("Observer 1: " + l));

        // Observer 2
        source.subscribe(l -> System.out.println("Observer 2: " + l));

        SomeTools.sleepSeconds(5L);
    }
}
