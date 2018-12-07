package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class TestBlockingFirstExample1 {

    @Test
    public void testFirst() {
        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");
        final String firstWithLengthFour = source.filter(s -> s.length() == 4).blockingFirst();

        assertEquals("Beta", firstWithLengthFour);
    }

}
