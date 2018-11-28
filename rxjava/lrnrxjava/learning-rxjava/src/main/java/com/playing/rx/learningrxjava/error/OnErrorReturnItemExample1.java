package com.playing.rx.learningrxjava.error;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class OnErrorReturnItemExample1 {
    public static void main(final String[] args) {
//        Observable.just(5, 2, 4, 0, 3, 2, 8)
//                .map(i -> 10.0 / i)
//                .onErrorReturnItem(-1.0)
//                .subscribe(i -> System.out.println("Received: " + i),
//                e -> System.out.println("Received error: " + e.getMessage())
//                );

//        Observable.just(5, 2, 4, 0, 3, 2, 8)
//                .map(i -> 10 / i)
//                .onErrorReturnItem(-1)
//                .subscribe(i -> System.out.println("RECEIVED: " + i),
//                        e -> System.out.println("RECEIVED ERROR: " + e)
//                );

        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorReturn(e -> - 1)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );

        SomeTools.sleepSeconds(5L);
    }
}
