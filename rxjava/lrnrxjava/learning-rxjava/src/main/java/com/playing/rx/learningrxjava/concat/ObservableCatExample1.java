package com.playing.rx.learningrxjava.concat;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ObservableCatExample1 {
    public static void main(final String[] args) {
        final Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        final Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        Observable.concat(source1, source2)
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
    }
}
