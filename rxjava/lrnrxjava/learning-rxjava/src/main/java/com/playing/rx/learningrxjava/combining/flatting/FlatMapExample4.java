package com.playing.rx.learningrxjava.combining.flatting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class FlatMapExample4 {
    public static void main(final String[] args) {
        final Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source1.flatMap(s -> Observable.fromArray(s.split("")), (s, r) -> s + "-" + r)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }
}
