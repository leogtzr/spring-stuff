package com.playing.rx.learningrxjava.operators;

import io.reactivex.Notification;
import io.reactivex.Observable;

public final class MaterializeExample2 {

    public static void main(final String[] args) {
        final Observable<Notification<String>> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .materialize()
                .publish().
                autoConnect(3)
                ;

        source
                .filter(Notification::isOnNext)
                .subscribe(n -> System.out.println("onNext=" + n.getValue()))
                ;

        source.filter(Notification::isOnComplete)
                .subscribe(n -> System.out.println("onComplete"))
                ;

        source.filter(Notification::isOnError)
                .subscribe(n -> System.out.println("onError"))
                ;
    }

}
