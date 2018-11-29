package com.playing.rx.learningrxjava.subjects;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public final class PublishSubjectExample1 {
    public static void main(final String[] args) {

        final Subject<String> subject = PublishSubject.create();

        subject.map(String::length)
                .subscribe(System.out::println);

        subject.onNext("Hola");
        subject.onNext("Mundo");
        subject.onNext("Cruel");

        SomeTools.sleepSeconds(5L);

    }
}
