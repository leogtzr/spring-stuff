package com.playing.rx.learningrxjava.buffering;

import io.reactivex.Observable;

public final class BufferSkipExample1 {
    public static void main(final String[] args) {

        Observable.range(1, 10)
                .buffer(2, 3)
                .subscribe(System.out::println)
                ;

    }
}
