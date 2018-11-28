package com.playing.rx.learningrxjava.concat;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public final class AmbiguousExample1 {
    public static void main(final String[] args) {

        //emit every second
        final Observable<String> source1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(2)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");

        // emit every 300 ms
        final Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300)
                        .map(l -> "Source2: " + l + " milliseconds")
                ;

        // emit Observable that emits first
        Observable.amb(Arrays.asList(source1, source2))
                .subscribe(i -> System.out.println("RECEIVED: " + i))
                ;

        SomeTools.sleepSeconds(5L);

        // ambWith() works the same say
//        source1.ambWith(source2)
//                .subscribe(....)

    }
}
