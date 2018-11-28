package com.playing.rx.learningrxjava.doon;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DoOnNextExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnNext(s -> System.out.println("Processing: " + s))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
