package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public final class ReplaySubjectExample1 {
    public static void main(final String[] args) {

        final Subject<String> subject = ReplaySubject.create();

        subject.subscribe(s -> System.out.println("Observer 1: " + s));

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        // The following observer receives all the previous emissions:
        subject.subscribe(s -> System.out.println("Observer 2: " + s));

        SomeTools.sleepSeconds(3L);

    }
}
