package com.playing.rx.learningrxjava.factories;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ObservableEmpty1 {
    public static void main(final String[] args) {

        // No emissions!
        Observable.never()
                .subscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));

        SomeTools.sleepSeconds(5L);
    }

}
