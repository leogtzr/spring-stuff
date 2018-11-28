package com.playing.rx.learningrxjava.error;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public class OnErrorResumeNextExample1 {
    public static void main(final String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                //.onErrorResumeNext(Observable.just(-1).repeat(3))
                .onErrorResumeNext(Observable.empty())
                .subscribe(i -> System.out.println("Received: " + i), e -> System.out.println("Received error: " + e))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
