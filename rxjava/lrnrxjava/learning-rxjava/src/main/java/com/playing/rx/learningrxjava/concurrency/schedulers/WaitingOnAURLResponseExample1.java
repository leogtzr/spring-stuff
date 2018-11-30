package com.playing.rx.learningrxjava.concurrency.schedulers;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Scanner;

public final class WaitingOnAURLResponseExample1 {
    public static void main(final String[] args) {

        Observable.fromCallable(() -> getResponse("http://wiki2"))
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(10L);

    }

    private static String getResponse(final String url) {
        try {
            return new Scanner(new java.net.URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        } catch (final Exception ex) {
            return ex.getMessage();
        }
    }
}
