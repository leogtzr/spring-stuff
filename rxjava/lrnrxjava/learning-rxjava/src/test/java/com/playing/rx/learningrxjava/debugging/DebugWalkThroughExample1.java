package com.playing.rx.learningrxjava.debugging;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

public class DebugWalkThroughExample1 {

    @Test
    public void debugWalkthrough() {
        //Declare TestObserver
        final TestObserver<String> testObserver = new TestObserver<>();

        // Source pushing three strings
        final Observable<String> items = Observable.just("521934/2342/Foxtrot",
                "Bravo/12112/78886/Tango",
                "283242/4542/Whiskey/2348562");

        //split and concatMap() on "/"
        items
                .concatMap(s -> Observable.fromArray(s.split("/")))
                // Filter for only alphabetic Strings using regex
        .filter(s -> s.matches("[A-Za-z]+"))
                .doOnNext(s -> System.out.println("Source pushed: "+ s))
                // Subscribe the TestObserver
        .subscribe(testObserver)
                ;

        // Why are no values being emitted
        System.out.println(testObserver.values());

        //This fails due to no values
        testObserver.assertValues("Foxtrot","Bravo","Tango","Whiskey");
    }

}
