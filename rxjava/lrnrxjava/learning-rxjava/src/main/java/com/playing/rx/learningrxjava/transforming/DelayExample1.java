package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class DelayExample1 {
    public static void main(final String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .delay(3, TimeUnit.SECONDS)             // delay the emissions for 3 seconds 
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
