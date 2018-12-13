package com.reactive.playing.reactorplaying.mono;

import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Mono;

public class TestDefaultIfEmpty {

    @Test
    public void givenAnEmptyMono_WhenTheDefaultIfEmptyOperatorIsUsedThenTheDefaultValueIsDeliveredAsResult() throws Exception {
        String defaultMessage = "Hello world";
        Mono<String> emptyMonoMessageProduced = Mono.empty();
        Mono<String> monoMessageDelivered = emptyMonoMessageProduced
                .defaultIfEmpty(defaultMessage);
        monoMessageDelivered.subscribe(messageDelivered ->
                Assert.assertEquals(defaultMessage, messageDelivered));
    }

}
