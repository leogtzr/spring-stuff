package com.playing.rx.learningrxjava.doon;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class DoOnSubscribeExample1 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnSubscribe(d -> System.out.println("Subscribing!"))
                .doOnDispose(() -> System.out.println("Disposing!"))
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
