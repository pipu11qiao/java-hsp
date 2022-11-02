package c14;

import java.util.stream.Stream;

public class FunctionMap3 {
    public static void main(String[] args) {
        Stream.of("3", "5", "7")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ", n));
        Stream.of("13", "15", "17")
                .mapToLong(Long::parseLong)
                .forEach(n -> System.out.format("%d ", n));
        Stream.of("3", "5.3", "7.5")
                .mapToDouble(Double::parseDouble)
                .forEach(n -> System.out.format("%f ", n));
    }
}
