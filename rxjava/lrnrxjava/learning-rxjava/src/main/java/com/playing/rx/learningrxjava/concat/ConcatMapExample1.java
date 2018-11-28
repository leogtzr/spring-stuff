package com.playing.rx.learningrxjava.concat;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ConcatMapExample1 {
    public static void main(final String[] args) {
        final Observable<String> source = Observable.just("Leo", "Gtz", "R");

        source.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
    }
}
