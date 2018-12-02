package com.playing.rx.learningrxjava.buffering;

import io.reactivex.Observable;

import java.util.HashSet;

public final class BufferExample2 {
    public static void main(final String[] args) {

        Observable.range(1, 50)
                .buffer(8, HashSet::new)
                .subscribe(System.out::println)
                ;

    }
}
