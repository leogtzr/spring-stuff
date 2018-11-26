package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class ObservableRange1 {
    public static void main(final String[] args) {
        // 10 is the total of emissions
        Observable.range(5, 10)
                .filter(i -> i >= 5)
                .subscribe(x -> System.out.println("Value: " + x));
    }
}
