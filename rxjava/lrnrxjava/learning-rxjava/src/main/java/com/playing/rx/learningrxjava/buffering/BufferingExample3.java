package com.playing.rx.learningrxjava.buffering;

import io.reactivex.Observable;

public final class BufferingExample3 {

    public static void main(final String[] args) {
        Observable.range(1, 10)
                .buffer(2, 1)
                .filter(buffer -> buffer.size() == 2)
                .subscribe(System.out::println)
                ;
    }

}
