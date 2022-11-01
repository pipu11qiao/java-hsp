package c14;

import static c14.Repeat.repeat;

public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("looping"));
        repeat(2, Looping::hi);
    }
}
