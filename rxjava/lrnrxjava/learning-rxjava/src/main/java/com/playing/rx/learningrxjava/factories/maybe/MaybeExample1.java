package com.playing.rx.learningrxjava.factories.maybe;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public final class MaybeExample1 {
    public static void main(final String[] args) {
        // has emissions:
        final Maybe<Integer> presentSource = Maybe.just(100);
        presentSource
                .subscribe(s -> System.out.println("Process 1 received: " + s), Throwable::printStackTrace, () -> System.out.println("Process 1 done!"));

        // no emission:
        final Maybe<Integer> emptySource = Maybe.empty();
        emptySource.subscribe(s -> System.out.println("Process 2 received: " + s), Throwable::printStackTrace, () -> System.out.println("Process 2 done!"));

        final Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source
                .firstElement()
                .subscribe(s -> System.out.println("Received: " + s), Throwable::printStackTrace, () -> System.out.println("Done! "));

    }
}
