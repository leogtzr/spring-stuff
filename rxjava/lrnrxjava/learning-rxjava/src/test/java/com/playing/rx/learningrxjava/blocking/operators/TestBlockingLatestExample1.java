package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestBlockingLatestExample1 {

    @Test
    public void testBlockingLatest() {
        final Observable<Long> source = Observable.interval(1, TimeUnit.MICROSECONDS)
                .take(1000);

        final Iterable<Long> iterable = source.blockingLatest();

        iterable.forEach(System.out::println);
    }

}
