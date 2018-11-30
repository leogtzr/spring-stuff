package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;

public final class AsyncSubjectExample1 {
    public static void main(final String[] args) {

        final Subject<String> subject = AsyncSubject.create();

        subject.subscribe(s -> System.out.println("Observer 1: " + s),
                Throwable::printStackTrace, () -> System.out.println("Observer 1 done!"));

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        subject.subscribe(s -> System.out.println("Observer 2: " + s),
                Throwable::printStackTrace, () -> System.out.println("Observer 1 done!"));

        SomeTools.sleepSeconds(5L);

    }
}
