package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class StartWithExample1 {
    public static void main(final String[] args) {

        final Observable<String> menu = Observable.just("Frijol", "con", "gorgojo");

        menu.startWith("Menu alrpvw")
                .subscribe(System.out::println);


        SomeTools.sleepSeconds(5L);

    }
}
