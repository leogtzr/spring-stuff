package com.playing.rx.learningrxjava.backpressure;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public final class FlowableGenerateExample1 {
    public static void main(final String[] args) {
        randomGenerator(1, 10000)
                .subscribeOn(Schedulers.computation())
                .doOnNext(i -> System.out.println("Emitting: " + i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    SomeTools.sleep(50);
                    System.out.println("Received: " + i);
                });

        SomeTools.sleepSeconds(10L);
    }

    private static Flowable<Integer> randomGenerator(int min, int max) {
        return Flowable.generate(emitter -> emitter.onNext(ThreadLocalRandom.current().nextInt(min, max)));
    }

}
