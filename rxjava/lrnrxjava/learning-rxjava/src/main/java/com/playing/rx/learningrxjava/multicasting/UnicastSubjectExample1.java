package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public final class UnicastSubjectExample1 {
    public static void main(final String[] args) {

        final Subject<Long> subject = UnicastSubject.create();
        Observable.interval(300, TimeUnit.MILLISECONDS).subscribe(subject);

        SomeTools.sleepSeconds(2L);

        // After two seconds everything is being pushed ...
        subject.subscribe(s -> System.out.println("Observer 1: " + s));

        SomeTools.sleepSeconds(2L);

    }
}
