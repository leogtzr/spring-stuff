package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ReduceExample2 {
    public static void main(final String[] args) {

        Observable.just(5, 3, 6)
                .reduce("", (total, next) -> total + (total.equals("") ? "" : ",") + next)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
