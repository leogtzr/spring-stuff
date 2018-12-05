package com.playing.rx.learningrxjava.transformer;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public final class ObservableTransformerExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(toImmutableList())
                .subscribe(System.out::println)
                ;
    }

    private static <T> ObservableTransformer<T, ImmutableList<T>> toImmutableList() {
        return  upstream -> upstream.collect(ImmutableList::<T>builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .toObservable(); // must turn Single into Observable
    }
}
