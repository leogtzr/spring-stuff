package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class TakeLastExample1 {
    public static void main(final String[] args) {

        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .takeLast(2)            // takes 8 and 9
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);

    }

}
