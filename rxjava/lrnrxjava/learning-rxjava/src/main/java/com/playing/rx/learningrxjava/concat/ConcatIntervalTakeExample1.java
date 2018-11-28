package com.playing.rx.learningrxjava.concat;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ConcatIntervalTakeExample1 {
    public static void main(final String[] args) {

        // emit every second, but only take 2 emissions
        final Observable<String> source = Observable.interval(1, TimeUnit.SECONDS)
                .take(2)
                .map(l -> l + 1)            // emit elapsed seconds
                .map(l -> "Source1: " + l + " seconds");

        // emit every 300 milliseconds
        final Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1) * 300)            // emit elapsed milliseconds
                .map(l -> "Source2: " + l + " milliseconds")
                ;

        Observable.concat(source, source2)
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
