package c14;

import static java.util.stream.IntStream.range;

public class Ranges {
    public static void main(String[] args) {
        int res = 0;
        for (int i : range(10, 20).toArray()) {
            res += i;
            System.out.println(res);
        }
        System.out.println(range(10, 20).sum());
    }
}
