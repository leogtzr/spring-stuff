package com.file.other;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class WritingToFileApp {

    private static final String FILE_NAME = "/home/leo/code/java/spring-stuff/filechannel-test/hello.txt";

    public static void main(final String[] args) {
        try (RandomAccessFile fileWriter = new RandomAccessFile(FILE_NAME, "rw");
            FileChannel channel = fileWriter.getChannel();
            RandomAccessFile reader = new RandomAccessFile(FILE_NAME, "r");
        ) {
            final ByteBuffer buff = ByteBuffer.wrap("Hola mundo alv\n".getBytes(StandardCharsets.UTF_8));
            channel.write(buff);

            final String fileContent = reader.readLine();
            System.out.println(fileContent);
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}
