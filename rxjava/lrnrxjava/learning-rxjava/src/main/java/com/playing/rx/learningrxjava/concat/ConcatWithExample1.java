package com.playing.rx.learningrxjava.concat;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ConcatWithExample1 {
    public static void main(String[] args) {
        final Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        final Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        source1.concatWith(source2)
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
