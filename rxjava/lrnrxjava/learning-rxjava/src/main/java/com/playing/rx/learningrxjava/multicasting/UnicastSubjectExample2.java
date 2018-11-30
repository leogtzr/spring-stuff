package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public final class UnicastSubjectExample2 {
    public static void main(final String[] args) {
        final Subject<String> subject = UnicastSubject.create();

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300) + " milliseconds")
                .subscribe(subject)
                ;

        SomeTools.sleepSeconds(2L);

        // multicast to support multiple Observers
        final Observable<String> multicast = subject.publish().autoConnect();

        // bring in first Observer
        multicast.subscribe(s -> System.out.println("Observer 1: " + s));

        SomeTools.sleepSeconds(2L);

        // bring in second Observer
        multicast.subscribe(s -> System.out.println("Observer 2: " + s));

        SomeTools.sleepSeconds(1L);
    }
}
