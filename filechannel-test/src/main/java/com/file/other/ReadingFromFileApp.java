package com.file.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ReadingFromFileApp {

    private static final String FILE_NAME = "/home/leo/code/java/spring-stuff/filechannel-test/pom.xml";

    public static void main(final String[] args) {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             FileChannel channel = fis.getChannel();
        ) {
            final ByteBuffer buff = ByteBuffer.allocate(1024);
            final int noOfBytesRead = channel.read(buff);
            final String fileContent = new String(buff.array(), StandardCharsets.UTF_8);
            System.out.println(fileContent);
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}
