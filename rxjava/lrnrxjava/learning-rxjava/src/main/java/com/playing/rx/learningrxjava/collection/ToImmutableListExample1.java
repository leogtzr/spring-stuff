package com.playing.rx.learningrxjava.collection;

import com.google.common.collect.ImmutableList;
import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import jdk.nashorn.internal.ir.annotations.Immutable;

public class ToImmutableListExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(s -> System.out.println("Received: " + s))
                ;

        SomeTools.sleepSeconds(5L);
    }
}
