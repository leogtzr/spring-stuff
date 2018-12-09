package com.playing.rx.learningrxjava.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public final class UnderstandingSchedulersExample2 {
    public static void main(final String[] args) {

        final Scheduler scheduler = Schedulers.computation();
        Scheduler.Worker worker = scheduler.createWorker();

        // run tasks now:
        worker.schedule(() -> System.out.println("Now!"));

        // delay tasks by 1 second:
        worker.schedule(() -> System.out.println("Delayed"), 1, TimeUnit.SECONDS);


        // repeat task every second
        worker.schedulePeriodically(() -> System.out.println("Repeat"), 0, 1, TimeUnit.SECONDS);

        SomeTools.sleepSeconds(5L);
        worker.dispose();

    }
}
