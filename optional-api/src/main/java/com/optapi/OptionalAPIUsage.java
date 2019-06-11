package com.optapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.util.stream.Collectors.*;

@SpringBootApplication
public class OptionalAPIUsage {

	public static void main(final String[] args) {
		final Integer theX = 3;
		final Optional<Integer> someX = Optional.ofNullable(theX);
		someX.ifPresentOrElse(x -> {
			System.out.println("Hellow!");
		}, () -> {
			System.out.println("Nothing to do here ... ");
		});
	}
}