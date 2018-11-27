package com.playing.rx.learningrxjava.operators.suppressing;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class TakeExample1 {
    public static void main(final String[] args) {

        final List<String> elements = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable.interval(1, TimeUnit.SECONDS)
                .take(elements.size())
                .map(i -> elements.get(Math.toIntExact(i)))
                .subscribe(System.out::println);

        sleep(TimeUnit.SECONDS.toMillis(5L));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");

        Observable.zip(
                Observable.interval(1000, TimeUnit.MILLISECONDS).take(5),
                Observable.fromArray(1, 2, 3, 4, 5),
                (aLong, integer) -> integer
                )
                .subscribe(System.out::println);

        sleep(TimeUnit.SECONDS.toMillis(10L));

        System.out.println("==================================================");

        Observable.zip(
                Observable.interval(1, TimeUnit.SECONDS).take(3),
                Observable.fromIterable(Arrays.asList("Mama", "Papa", "Edgar", "Brenda", "Leo")),
                        (period, name) -> name
                ).subscribe(System.out::println);

        sleep(TimeUnit.SECONDS.toMillis(5L));



    }

    private static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
