package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class AutoConnectExample1 {
    public static void main(final String[] args) {

        final Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> SomeTools.randomInt())
                .publish()
                .autoConnect(2)         // the default is 1
                ;

        // Observer 1 - print each random integer
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));

        // Observer 2 - sum the random integers, then print
        threeRandoms.reduce(0, (total, next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i))
                ;

        // Observer 3 - receives nothing (autoConnect() is set to two)
        threeRandoms.subscribe(i -> System.out.println("Observer 3: " + i));

        SomeTools.sleepSeconds(3L);

    }
}
