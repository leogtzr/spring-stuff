package com.playing.rx.learningrxjava.switching;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class SwitchMapExample1 {
    public static void main(String[] args) {
        final Observable<String> items = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota");
        //delay each String to emulate an intense calculation

        final Observable<String> processString = items.concatMap(s -> Observable.just(s).delay(SomeTools.randomSleepTime(), TimeUnit.MILLISECONDS))
                ;

        // run processString every 5 seconds, and kill each previous instance to start next
        Observable.interval(5, TimeUnit.SECONDS)
                .switchMap(i ->
                        processString.doOnDispose(() -> System.out.println("Disposing! Starting next!"))
                ).subscribe(System.out::println);

        SomeTools.sleepSeconds(20L);
    }
}
