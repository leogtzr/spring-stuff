package com.reactive.playing.reactorplaying.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;

@RestController
@RequestMapping("singer")
public class SingerResource {

    @GetMapping(value = "/{singer}/comments", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> querySingerComments(@PathVariable final String singer) {
        // generate one flux element per second
        final Flux<String> intervalToGenerateDates = Flux.interval(Duration.ofSeconds(1)).map(x -> new Date().toString());
        return intervalToGenerateDates;
    }

}
