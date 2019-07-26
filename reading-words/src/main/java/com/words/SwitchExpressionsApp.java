package com.words;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwitchExpressionsApp {

    public enum Size {S, M, L, XL};

    public static void main(final String[] args) {

    }

    private static void foo(final Size size) {
        final int height = switch(size) {
			case S -> 0;
			case M -> 1;
			case L -> 2;
			case XL -> 3;
			default -> -1;
        };
    }

}
