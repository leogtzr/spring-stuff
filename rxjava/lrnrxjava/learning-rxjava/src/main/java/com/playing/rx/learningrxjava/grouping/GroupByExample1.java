package com.playing.rx.learningrxjava.grouping;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public final class GroupByExample1 {
    public static void main(final String[] args) {
        final Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        final Observable<GroupedObservable<Integer, String>> byLengths = source.groupBy(String::length);

        //byLengths.subscribe(System.out::println);
        byLengths.flatMapSingle(l -> l.toList())
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }
}
