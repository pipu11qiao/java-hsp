package c17;

import java.nio.file.*;

public class Find {
    static Path test = Paths.get("src/main/java/c17/test");

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();

        Files.createDirectory(test.resolve("dir.tmp"));
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");

        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);

        System.out.println("**********");
        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");

        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);

        System.out.println("**********");


        Files.walk(test)
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
