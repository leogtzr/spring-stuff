package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class SkipLastExample1 {
    public static void main(final String[] args) {

//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .skipLast(2)
//                .subscribe(System.out::println)
//        ;

        Observable.range(1, 10)
                .skipLast(3)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }

}
