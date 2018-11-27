package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class TakeWhileExample1 {

    public static void main(final String[] args) {

        Observable.range(1, 10)
                .takeWhile(i -> i < 5)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);

    }

}
