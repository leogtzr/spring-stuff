package com.playing.rx.learningrxjava;

import io.reactivex.Observable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningRxjavaApplication {
	public static void main(final String[] args) {
        final Observable<String> myStrings = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        // myStrings.subscribe(System.out::println);
        myStrings
                .map(String::length)
                .subscribe(System.out::println);
	}
}
