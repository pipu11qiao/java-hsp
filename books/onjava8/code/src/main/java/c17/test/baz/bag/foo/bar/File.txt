package c17;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directories {
    static String pathStr = "src/main/java/c17/test";
    static Path test = Paths.get(pathStr);
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
//        System.out.println(sep);
        return Paths.get(pathStr, String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if (Files.exists(test)) {
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();

        try {
            Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("Nope, that doesn't work.");
        }
        populateTestDir();
        Path tempdir = Files.createTempDirectory(test,"DIR_");
        Files.createTempFile(tempdir,"pre",".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("***********");
        Files.walk(test).forEach(System.out::println);
    }

    static void populateTestDir() throws Exception {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
//            System.out.println("variant:" + variant);
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);

            }

            Files.copy(Paths.get("src/main/java/c17/Directories.java"), variant.resolve("File.txt"));
            Files.createTempFile(variant, null, null);

        }
    }
}
