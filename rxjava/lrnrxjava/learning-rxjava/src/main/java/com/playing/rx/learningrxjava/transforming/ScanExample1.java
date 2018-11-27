package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ScanExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 10)
                .scan((acc, n) -> acc + n)
                .lastElement()
                .subscribe(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");

        

        SomeTools.sleepSeconds(5L);

    }
}
