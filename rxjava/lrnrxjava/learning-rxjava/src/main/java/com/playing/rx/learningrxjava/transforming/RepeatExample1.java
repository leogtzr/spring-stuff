package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class RepeatExample1 {
    public static void main(final String[] args) {

        Observable.just("Leo", "Gtz", "Ramirez")
                .repeat(3)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
