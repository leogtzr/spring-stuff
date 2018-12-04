package com.playing.rx.learningrxjava.backpressure;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public final class BackpressureStrategyExample1 {
<<<<<<< Updated upstream

    public static void main(final String[] args) {
        final Flowable<Integer> source = Flowable.create(emitter -> {
            for (int i = 0; i < 100; i++) {
=======
    public static void main(final String[] args) {
        final Flowable<Integer> source = Flowable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
>>>>>>> Stashed changes
                if (emitter.isCancelled())
                    return;
                emitter.onNext(i);
            }
<<<<<<< Updated upstream
            emitter.onComplete();
=======
>>>>>>> Stashed changes
        }, BackpressureStrategy.BUFFER);

        source.observeOn(Schedulers.io())
                .subscribe(System.out::println);

<<<<<<< Updated upstream
        SomeTools.sleep(10L);
    }

=======
        SomeTools.sleepSeconds(10L);
    }
>>>>>>> Stashed changes
}
