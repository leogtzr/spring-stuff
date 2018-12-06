package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestBlockingNextExample1 {

    @Test
    public void testBlockingNext() {
        final Observable<Long> source = Observable.interval(1, TimeUnit.MICROSECONDS)
                .take(1_000L)
                ;

        final Iterable<Long> iterable = source.blockingNext();

        for (long i : iterable) {
            System.out.println(i);
        }
    }

}
