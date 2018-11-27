package com.playing.rx.learningrxjava.operators.suppressing;

import io.reactivex.Observable;

public final class FilterExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .filter(s -> s.length() != 5)               // Filter suppress emissions ...
                .subscribe(s  -> System.out.println("Received: " + s));
    }
}
