package com.playing.rx.learningrxjava.combining.merging;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ObservableMergeExample1 {

    public static void main(final String[] args) {

        final Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        final Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        Observable.merge(source1, source2)
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        System.out.println("~~~~~~~~~~~~>");

        Observable.just(1, 2, 3).mergeWith(Observable.just(5, 4, 7))
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);



    }


}
