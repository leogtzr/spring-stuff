package com.playing.rx.learningrxjava.transforming;


import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class AllExample1 {
    public static void main(final String[] args) {

        Observable.just(5, 3, 7)
        .all(x -> x % 2 != 0)               // check if all the emissions are even
                                            // if one of the emissions doesn't met the condition then it will call onComplete() immediately.
        .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
