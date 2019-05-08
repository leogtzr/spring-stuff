package com.words;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@SpringBootApplication
public class ReadingWordsApplication {

	private static final Set<String> AVOID = new HashSet<>(Arrays.asList(
			"de", "y", "la", "que", "el", "en", "ellos", "ellas",
			"a", "se", "su", "las", "los", "con", "por", "lo", "como", "del", "un", "al", "o", "el", "él",
			"una", "no", "le", "para", "&"
	));

	public static void main(final String[] args) throws IOException {

		if (args == null || args.length < 1) {
			throw new IllegalArgumentException("theJar.jar <file>");
		}

		final FileSystemResource fileSystemResource = new FileSystemResource(args[0]);

		final Map<String, Long> count = Files.
				lines(fileSystemResource.getFile().toPath())
				.map(line -> line.split("[, ]+"))
				.flatMap(Arrays::stream)
				.map(s -> s.replaceAll("[^a-zA-z]+", ""))
				.filter(s -> !s.isEmpty())
				.filter(word -> !AVOID.contains(word.toLowerCase()
				))
				.collect(groupingBy(w -> w.toLowerCase(), counting()));

		count.keySet().forEach(k -> System.out.printf("%d -> '%s'\n", count.get(k), k));
	}
}
