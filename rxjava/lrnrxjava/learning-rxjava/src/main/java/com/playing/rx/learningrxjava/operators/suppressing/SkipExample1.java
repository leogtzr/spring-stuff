package com.playing.rx.learningrxjava.operators.suppressing;

import io.reactivex.Observable;

public final class SkipExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 100)
                .skip(90)               // skips from 1 to 89 ...
                .subscribe(System.out::println);

        /*
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);
         */

    }
}
