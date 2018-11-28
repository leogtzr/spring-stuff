package com.playing.rx.learningrxjava.doon;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DoOnErrorExample1 {
    public static void main(final String[] args) {

        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .doOnError(e -> System.out.println("Source failed!"))
                .map(i -> 10 / i)
                .doOnError(e -> System.out.println("Division failed!"))
                .subscribe(i -> System.out.println("Received: " + i), e -> System.out.println("Received ERROR: " + e.getMessage()))
                ;

        SomeTools.sleepSeconds(5L);

    }
}
