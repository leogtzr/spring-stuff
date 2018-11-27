package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.Comparator;

public final class SortedExample1 {
    public static void main(String[] args) {
        //Observable.just(7, 4, 6).sorted().subscribe(System.out::println);
        Observable.just(7, 4, 6).sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }
}
