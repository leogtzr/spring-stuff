package com.playing.rx.learningrxjava.combining.flatting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public class FlatMapExample2 {
    public static void main(String[] args) {
        final Observable<String> source = Observable
                .just("521934/2342/FOXTROT", "21962/12112/78886/TANGO", "283242/4542/WHISKEY/2348562");

        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+"))
                .subscribe(System.out::println)
                ;

        SomeTools.sleepSeconds(5L);
    }
}
