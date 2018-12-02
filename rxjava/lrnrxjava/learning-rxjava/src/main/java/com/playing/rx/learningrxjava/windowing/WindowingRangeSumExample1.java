package com.playing.rx.learningrxjava.windowing;

import io.reactivex.Observable;

public final class WindowingRangeSumExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 50)
                .window(5)
                .flatMapSingle(obs -> obs.reduce(0, (acc, n) -> acc + n))
                .subscribe(System.out::println)
                ;

    }
}
