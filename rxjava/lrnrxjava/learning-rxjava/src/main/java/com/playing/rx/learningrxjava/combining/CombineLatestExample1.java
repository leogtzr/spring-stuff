package com.playing.rx.learningrxjava.combining;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CombineLatestExample1 {
    public static void main(final String[] args) {

        final Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);

        final Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.combineLatest(source1, source2, (l1, l2) -> "Source 1: " + l1 + ", source 2: " + l2)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
    }
}
