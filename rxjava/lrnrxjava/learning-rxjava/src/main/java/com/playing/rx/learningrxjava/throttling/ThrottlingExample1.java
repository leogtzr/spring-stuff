package com.playing.rx.learningrxjava.throttling;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class ThrottlingExample1 {

    public static void main(final String[] args) {

        final Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 100)            // map to elapsed time
                .map(i -> "Source 1: " + i)
                .take(10)
                ;

        final Observable<String> source2 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)            // map to elapsed time
                .map(i -> "Source 2: " + i)
                .take(3)
                ;

        final Observable<String> source3 = Observable.interval(2000, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 2000)            // map to elapsed time
                .map(i -> "Source 3: " + i)
                .take(2)
                ;

        Observable.concat(source1, source2, source3)
                .throttleLast(500, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(6L);
    }

}
