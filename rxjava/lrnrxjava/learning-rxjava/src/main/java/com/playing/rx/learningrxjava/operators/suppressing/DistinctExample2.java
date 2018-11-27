package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final class DistinctExample2 {
    public static void main(final String[] args) {

        final Function<String, Boolean> fn = x -> x.length() > 4;

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .distinct(fn)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5);

    }
}
