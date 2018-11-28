package com.playing.rx.learningrxjava.zipping;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Observable;

public final class ZippingExample1 {
    public static void main(final String[] args) {

        final Observable<String> source1 = Observable.just("uno", "dos", "tres");
        final Observable<Integer> source2 = Observable.just(1, 2, 3);

        //source1.zipWith(source2, (s, i) -> s + "-" + i).subscribe(System.out::println);

        Observable.zip(source1, source2, (s, i) -> s + "-" + i).subscribe(System.out::println);

        SomeTools.sleepSeconds(5L);
    }
}
