package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBlockingForEachExample1 {

    @Test
    public void testBlockingForEach() {
        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        source.filter(s -> s.length() == 5)
                .blockingForEach(s -> assertEquals(5, s.length()));
    }

}
