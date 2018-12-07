package com.playing.rx.learningrxjava.blocking.operators;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestBlockingGetExample1 {

    @Test
    public void testSingle() {
        final Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        final List<String> allWithLengthFour = source.filter(s -> s.length() == 4).toList().blockingGet();

        assertThat(allWithLengthFour, is(Arrays.asList("Beta", "Zeta")));

    }

}
