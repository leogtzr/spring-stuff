package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBlockingIterableExample1 {

    @Test
    public void testIterable() {
        final Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        final Iterable<String> allWithLengthFive = source.filter(s -> s.length() == 5)
                .blockingIterable();

        allWithLengthFive.forEach(s -> assertEquals(5, s.length()));
    }

}
