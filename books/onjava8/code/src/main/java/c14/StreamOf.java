package c14;

import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {
        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.1, 2.22, 3.55)
                .forEach(System.out::println);
    }
}
