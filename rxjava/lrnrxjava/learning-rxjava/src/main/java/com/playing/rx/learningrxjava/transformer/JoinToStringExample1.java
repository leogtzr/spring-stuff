package com.playing.rx.learningrxjava.transformer;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public final class JoinToStringExample1 {
    public static void main(final String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(joinToString("/"))
                .subscribe(System.out::println)
                ;
    }

    private static ObservableTransformer<String, String>  joinToString(final String separator) {
        return stream -> stream.collect(StringBuilder::new, (b, s) -> {
            if (b.length() == 0)
                b.append(s);
            else
                b.append(separator).append(s);
        }).map(StringBuilder::toString)
                .toObservable();
    }
}
