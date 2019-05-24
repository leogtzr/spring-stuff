package com.file;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import static java.util.stream.Collectors.*;

@SpringBootApplication
public class FileChannelApp {

	private static final Set<String> AVOID = new HashSet<>(Arrays.asList(
			"de", "y", "la", "que", "el", "en", "ellos", "ellas",
			"a", "se", "su", "las", "los", "con", "por", "lo", "como", "del", "un", "al", "o", "el", "él",
			"una", "no", "le", "para", "&"
	));

	public static void main(final String[] args) throws IOException {

		if (args == null || args.length < 1) {
			throw new IllegalArgumentException("theJar.jar <file>");
		}

		try (RandomAccessFile reader = new RandomAccessFile(args[0], "r")) {
			final FileChannel channel = reader.getChannel();
			final ByteArrayOutputStream out = new ByteArrayOutputStream();

			int bufferSize = 1024;
			if (bufferSize > channel.size()) {
				bufferSize = (int)channel.size();
			}
			final ByteBuffer buff = ByteBuffer.allocate(bufferSize);

			while (channel.read(buff) > 0) {
				out.write(buff.array(), 0, buff.position());
				buff.clear();
			}

			final String fileContent = new String(out.toByteArray(), StandardCharsets.UTF_8);
			System.out.println(fileContent);
		}

//		final FileSystemResource fileSystemResource = new FileSystemResource(args[0]);
//
//		final Map<String, Long> count = Files.
//				lines(fileSystemResource.getFile().toPath())
//				.map(line -> line.split("[, ]+"))
//				.flatMap(Arrays::stream)
//				.map(s -> s.replaceAll("[^a-zA-z]+", ""))
//				.filter(s -> !s.isEmpty())
//				.filter(word -> !AVOID.contains(word.toLowerCase()
//				))
//				.collect(groupingBy(w -> w.toLowerCase(), counting()));
//
//		count.keySet().forEach(k -> System.out.printf("%d -> '%s'\n", count.get(k), k));
	}
}
