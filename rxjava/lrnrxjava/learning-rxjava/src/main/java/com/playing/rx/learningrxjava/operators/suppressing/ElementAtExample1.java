package com.playing.rx.learningrxjava.operators.suppressing;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ElementAtExample1 {
    public static void main(final String[] args) {
        Observable.just("Leo", "Brenda", "Edgar", "Maria", "Edgar")
                .elementAt(2)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5);
    }
}
