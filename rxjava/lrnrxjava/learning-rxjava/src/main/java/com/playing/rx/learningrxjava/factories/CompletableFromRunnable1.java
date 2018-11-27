package com.playing.rx.learningrxjava.factories;

import io.reactivex.Completable;

public final class CompletableFromRunnable1 {
    public static void main(final String[] args) {
        Completable.fromRunnable(CompletableFromRunnable1::runProcess)
                .subscribe(() -> System.out.println("We are done!"));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Just calls the action specified.
        Completable.complete()
                .subscribe(() -> System.out.println("Done! :)"));
    }

    private static void runProcess() {
        System.out.println("Hello world!");
    }

}
