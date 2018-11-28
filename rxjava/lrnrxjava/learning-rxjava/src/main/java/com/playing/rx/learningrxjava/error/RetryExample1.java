package com.playing.rx.learningrxjava.error;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public class RetryExample1 {
    public static void main(final String[] args) {
        Observable.just(5, 2, 1, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .retry(2)
                .subscribe(i -> System.out.println("Received: " + i), e -> System.out.println("Received error: " + e))
                ;

        SomeTools.sleepSeconds(2L);
    }
}
