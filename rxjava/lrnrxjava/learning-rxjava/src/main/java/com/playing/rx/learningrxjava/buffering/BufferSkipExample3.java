package com.playing.rx.learningrxjava.buffering;

import io.reactivex.Observable;

public final class BufferSkipExample3 {
    public static void main(final String[] args) {

        Observable.range(1, 10)
                .buffer(3, 1)
                .subscribe(System.out::println)
                ;

    }
}
