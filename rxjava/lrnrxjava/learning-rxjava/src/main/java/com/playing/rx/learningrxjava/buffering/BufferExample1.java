package com.playing.rx.learningrxjava.buffering;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class BufferExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 50)
                .map(x -> SomeTools.randomInt())
                .buffer(8)
                .subscribe(System.out::println)
                ;

    }
}
