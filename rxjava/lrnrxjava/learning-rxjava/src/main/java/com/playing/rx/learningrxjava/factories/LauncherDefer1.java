package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class LauncherDefer1 {

    private static int start = 1;
    private static int count = 5;

    public static void main(final String[] args) {
        final Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));
        source.subscribe(i -> System.out.println("Observer 1: " + i));

        // Modify the count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }
}
