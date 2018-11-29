package com.playing.rx.learningrxjava.multicasting;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class RefCountExample1 {
    public static void main(final String[] args) {
        final Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS)
                .publish()
                .refCount()
                ;

        // Observer 1
        seconds.take(5).subscribe(i -> System.out.println("Observer 1: " + i));

        SomeTools.sleepSeconds(3L);

        // Observer 2:
        seconds.take(2)
                .subscribe(l -> System.out.println("\tObserver 2: " + l))
                ;

        SomeTools.sleepSeconds(3L);
        // there should be no more observers at this point ... but

        // Observer 3
        /*
            The other two observers are gone, but this is new ... so the emissions start over!
            publish().refCount() is equal to .share()
         */
        seconds.subscribe(l -> System.out.println("Observer 3: " + l));

        SomeTools.sleepSeconds(3L);
    }
}
