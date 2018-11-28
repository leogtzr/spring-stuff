package com.playing.rx.learningrxjava.zipping;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public final class ZipWithIntervalExample1 {
    public static void main(final String[] args) {

        final Observable<String> source1 = Observable.just("Leo", "Gtz", "R");
        final Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        source1.zipWith(seconds, (s, i) -> s)
                .subscribe(s -> System.out.println("Received " + s + " at " + LocalTime.now()));

        SomeTools.sleepSeconds(5L);

    }
}
