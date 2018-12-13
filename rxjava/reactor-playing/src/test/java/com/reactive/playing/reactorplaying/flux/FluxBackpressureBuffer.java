package com.reactive.playing.reactorplaying.flux;

import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxBackpressureBuffer {

    @Test
    public void givenAFluxWith10Elements_WhenBackPressureAsksForChunksOf3Elements_ThenYouHave4Chunks() throws Exception {
        final List<Integer> digitsArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        final Flux<Integer> fluxWithDigits = Flux.fromIterable(digitsArray);
        fluxWithDigits.buffer(3)
                .log()
                .subscribe(elements -> Assert.assertTrue(elements.size() <= 3));
    }

}
