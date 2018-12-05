package com.playing.rx.learningrxjava.transformer;

import com.google.common.collect.ImmutableList;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;

public final class FlowableTransformerExample1 {
    public static void main(final String[] args) {
        Flowable.just("alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(toImmutableList())
                .subscribe(System.out::println)
                ;

        Flowable.range(1, 10)
                .compose(toImmutableList())
                .subscribe(System.out::println);
    }

    private static <T> FlowableTransformer<T, ImmutableList<T>> toImmutableList() {
        return  upstream -> upstream.collect(ImmutableList::<T>builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .toFlowable(); // must turn Single into Flowable
    }
    
}
