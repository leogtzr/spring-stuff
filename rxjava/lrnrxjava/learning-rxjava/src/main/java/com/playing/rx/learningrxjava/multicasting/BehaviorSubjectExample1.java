package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public final class BehaviorSubjectExample1 {
    public static void main(final String[] args) {
        final Subject<String> subject = BehaviorSubject.create();

        subject.subscribe(s -> System.out.println("Observer 1: " + s));

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");

        subject.subscribe(s -> System.out.println("Observer 2: " + s));

        SomeTools.sleepSeconds(5L);
    }
}
