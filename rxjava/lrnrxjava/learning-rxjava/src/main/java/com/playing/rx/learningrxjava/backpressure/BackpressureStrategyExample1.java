package com.playing.rx.learningrxjava.backpressure;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public final class BackpressureStrategyExample1 {

    public static void main(final String[] args) {
        final Flowable<Integer> source = Flowable.create(emitter -> {
            for (int i = 0; i < 100; i++) {
                if (emitter.isCancelled())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

        source.observeOn(Schedulers.io())
                .subscribe(System.out::println);

        SomeTools.sleep(10L);
    }

}
