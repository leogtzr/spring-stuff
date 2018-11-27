package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class StartWithArrayExample1 {
    public static void main(final String[] args) {

        final Observable<String> menu = Observable.just("Frijol", "con", "gorgojo");

        // Ideal to seed an initial value or precede the emissions ...
        menu.startWithArray("Menu", "----------------O------")
                .subscribe(System.out::println);


        SomeTools.sleepSeconds(5L);


    }
}
