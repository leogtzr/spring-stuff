package com.playing.rx.learningrxjava.combining.merging;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ObservableMergeExample2 {
    public static void main(final String[] args) {

        final Observable<Integer> source1 = Observable.just(1);
        final Observable<Integer> source2 = Observable.just(2);
        final Observable<Integer> source3 = Observable.just(3);
        final Observable<Integer> source4 = Observable.just(4);

        Observable.mergeArray(source1, source2, source3, source4)
                .subscribe(i -> System.out.println("Received: " + i))
                ;

        SomeTools.sleepSeconds(5L);

    }
}
