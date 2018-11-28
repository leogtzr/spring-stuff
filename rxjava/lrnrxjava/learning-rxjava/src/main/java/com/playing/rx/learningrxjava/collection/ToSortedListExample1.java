package com.playing.rx.learningrxjava.collection;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ToSortedListExample1 {
    public static void main(final String[] args) {

        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .toSortedList()
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
