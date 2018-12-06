package com.playing.rx.learningrxjava.blocking;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class TestBlockingSubscribeExample1 {

    @Test
    public void testBlockingSubscribe() {
        final AtomicInteger hitCount = new AtomicInteger();
        final Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);

        source.blockingSubscribe(i -> hitCount.incrementAndGet());

        assertEquals(5, hitCount.get());
    }

}
