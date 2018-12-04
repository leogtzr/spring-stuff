package com.playing.rx.learningrxjava.backpressure.conversion;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class RangeToFlowableExample1 {
    public static void main(final String[] args) {

        final Observable<Integer> source = Observable.range(1, 1000)
                ;

        source.toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);

        SomeTools.sleep(10L);

    }
}
