package c17;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("(" + id + ")r" + base.relativize(result));
        } else {
            System.out.println("(" + id + ")r" + result);
        }
        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("os.name"));
        System.out.println(base);

        Path p = Paths.get("src/main/java/c17/AddAndSubtractPaths.java").toAbsolutePath();
        show(1, p);

        Path convoluted = p.getParent().getParent()
                .resolve("c16").resolve("..")
                .resolve(p.getParent().getFileName());
        System.out.println("convoluted: " + convoluted);
        show(2, convoluted);
        show(3, convoluted.normalize());


        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());

        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());

        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("c17"));
        show(11, Paths.get("nonexistent"));
    }
}
