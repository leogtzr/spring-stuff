package com.playing.rx.learningrxjava.backpressure;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public final class FlowableRangeExample1 {
    public static void main(final String[] args) {
        Flowable.range(1, 1000)
                .doOnNext(s -> System.out.println("Source pushed: " + s))
                .observeOn(Schedulers.io())
                .map(i -> SomeTools.intenseCalculation(i))
                .subscribe(s -> System.out.println("Subscriber received: " + s), Throwable::printStackTrace, () -> System.out.println("Done!"));

        SomeTools.sleepSeconds(20L);
    }
}
