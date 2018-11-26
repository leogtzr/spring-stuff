package com.playing.rx.learningrxjava.factories;

import io.reactivex.Observable;

public final class ObservableEmpty1 {
    public static void main(final String[] args) {

        // No emissions!
        Observable.never()
                .subscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));

        sleep(5000);
    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
