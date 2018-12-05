package com.playing.rx.learningrxjava.sideffects;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

import java.util.concurrent.atomic.AtomicInteger;

public final class SharingStateIssueExample1 {
    public static void main(final String[] args) {
        Observable<IndexedValue<String>> indexedStrings = Observable.just("alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(withIndex())
                ;

        indexedStrings.subscribe(v -> System.out.println("Subscriber 1: " + v));
        indexedStrings.subscribe(v -> System.out.println("Subscriber 2: " + v));
    }

    private static <T>ObservableTransformer<T, IndexedValue<T>> withIndex() {
//        final AtomicInteger indexer = new AtomicInteger(-1);
//        return upstream -> upstream.map(v -> new IndexedValue<>(indexer.incrementAndGet(), v));

        return upstream -> Observable.defer(() -> {
            final AtomicInteger indexer = new AtomicInteger(-1);
            return upstream.map(v -> new IndexedValue<>(indexer.incrementAndGet(), v));
        });

    }

    private static final class IndexedValue<T> {
        private final int index;
        private final T value;

        public IndexedValue(final int index, final T value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return index + " - " + value;
        }
    }

}
