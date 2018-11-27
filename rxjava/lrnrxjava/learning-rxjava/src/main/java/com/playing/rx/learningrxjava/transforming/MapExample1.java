package com.playing.rx.learningrxjava.transforming;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class MapExample1 {
    public static void main(String[] args) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");

        Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
                //.map(dtf::parse)
                .map(s -> LocalDate.parse(s, dtf))
                .subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);

    }
}
