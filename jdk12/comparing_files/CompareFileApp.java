import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompareFileApp {
    public static void main(final String[] args) throws IOException {
        final Path tempDir = Paths.get(".");
        
        final Path helloWorld = tempDir.resolve("helloWorld.txt");
        createFile(helloWorld, "Hello World!");

        final Path java12 = tempDir.resolve("java12.txt");
        createFile(java12, "Released on March 19th, 2019");

        final Path helloJava = tempDir.resolve("hellojava.txt");
        createFile(helloJava, "Hello Java!");

        long same = Files.mismatch(helloWorld, helloWorld);
        System.out.println(same);

    }

    private static void createFile(Path path, String content) {
        try {
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write " +
                    "content to file", e);
        }
    }
}