package com.playing.rx.learningrxjava.buffering.time;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class BufferExample4 {
    public static void main(final String[] args) {

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300)
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(4L);

    }
}
