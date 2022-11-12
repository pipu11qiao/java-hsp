package needExercise;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Dog {
    @Override
    public String toString() {
        return "dog";
    }
}

class Cat {
    @Override
    public String toString() {
        return "cat";
    }
}



public class StreamCreate {
    public static Stream.Builder<String> builder = Stream.builder();
    public static void main(String[] args) {

        // Stream.of()
//        Stream.of(new Dog(), new Cat(), new Dog()).forEach(System.out::println);

        // 集合 stream()方法
//        Arrays.asList("abcde".split("")).stream().forEach(System.out::println);

        // 随机数
//        new Random().ints(4,20).limit(7).forEach(System.out::println);
        // range
//        IntStream.range(3,5).forEach(System.out::println);
        // generate Supplier<T>
//        Stream.generate(()->5).limit(10).forEach(System.out::println);
        // Arrays.stream
//        int[] arr = new int[]{3, 5, 5};
//        Arrays.stream(arr).forEach(System.out::println);
//        String str = "s**s**s";
//        Pattern.compile("\\*").splitAsStream(str).forEach(System.out::println);
//        Stream.iterate(0, (n) -> {
//            return n + n + 1;
//        }).limit(10).forEach(System.out::println);

        builder.add("h");
        builder.add("e");
        builder.add("l");
        builder.add("l");
        builder.add("o");
        builder.build().forEach(System.out::println);

    }
}
