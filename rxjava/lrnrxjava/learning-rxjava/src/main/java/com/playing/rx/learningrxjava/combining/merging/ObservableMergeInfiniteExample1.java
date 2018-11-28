package com.playing.rx.learningrxjava.combining.merging;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ObservableMergeInfiniteExample1 {
    public static void main(final String[] args) {
        final Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(l -> l + 1)
                .map(l -> "Source1: " + l + " seconds")
                ;

        final Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l + 1) * 300)
                .map(l -> "Source2: " + l + " milliseconds")
                ;

        // the order is not guaranteed 
        Observable.merge(source1, source2)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);

    }
}
