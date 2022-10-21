package day1;

import java.util.Scanner;

public class SomeDemo {
    public static void main(String[] args) {

        String s1 = "Hello!";

        String s2 = new String(new char[]{'H', 'e', 'l', 'l', 'o', '!'});

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1.contains("ll"));
        System.out.println(s1.indexOf("l"));
        System.out.println(s1.lastIndexOf("l"));
        System.out.println(s1.startsWith("He"));
        System.out.println(s1.endsWith("o"));
        System.out.println(s1.substring(2));
        System.out.println(s1.substring(2, 4));
        // trim strip stripLeading stripTrailing
        // isEmpty isBlank

        System.out.println(s1.replace("l", "w"));
        // replace replaceAll
        // split
        // join
        // formatted
        // format

        // valueOf
        //
    }
}

class StringBuilderDemo {
    public static void main(String[] args) {
        var sb = new StringBuilder(3000);
        String[] numArr = new String[1000];
        for (int i = 0; i < 1000; i++) {
            numArr[i] = String.valueOf(i);
        }
        System.out.println(String.join(",", numArr));
    }
}