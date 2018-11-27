package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.time.LocalDate;

public final class AllExample2 {
    public static void main(final String[] args) {

        Observable.just("2016-01-01", "2016-05-02", "2016-09-12", "2016-04-03")
                .map(LocalDate::parse)
                .any(dt -> dt.getMonthValue() >= 6)
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }
}
