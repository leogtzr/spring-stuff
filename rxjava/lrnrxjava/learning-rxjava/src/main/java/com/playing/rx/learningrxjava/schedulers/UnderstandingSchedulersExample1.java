package com.playing.rx.learningrxjava.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public final class UnderstandingSchedulersExample1 {
    public static void main(final String[] args) {

        final Scheduler scheduler = Schedulers.computation();

        // run tasks now:
        scheduler.scheduleDirect(() -> System.out.println("Now"));

        // Delay task for 1 second
        scheduler
                .schedulePeriodicallyDirect(() -> doSomething(), 0, 1, TimeUnit.SECONDS);

        SomeTools.sleepSeconds(5L);

    }

    private static void doSomething() {
        System.out.println("Holis a todis");
    }

}
