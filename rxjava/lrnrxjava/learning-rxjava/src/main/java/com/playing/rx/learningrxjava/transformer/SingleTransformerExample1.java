package com.playing.rx.learningrxjava.transformer;

import io.reactivex.Observable;
import io.reactivex.SingleTransformer;

import java.util.Collection;
import java.util.Collections;

public final class SingleTransformerExample1 {

    public static void main(final String[] args) {
        Observable.just("alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toList()
                .compose(toUnmodifiable())
                .subscribe(System.out::println);
    }

    private static <T> SingleTransformer<Collection<T>, Collection<T>> toUnmodifiable() {
        return singleObserver -> singleObserver.map(Collections::unmodifiableCollection);
    }

}
