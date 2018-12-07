package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestBlockingLastExample1 {

    @Test
    public void testLast() {
        final Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        final String lastWithLengthFour = source.filter(s -> s.length() == 4)
                .blockingLast();

        assertThat(lastWithLengthFour, is("Zeta"));

    }

}
