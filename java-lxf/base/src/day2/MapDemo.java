package day2;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Student s = new Student("Xiaoming", 27);
        Map<String,Student> map = new HashMap<>();
        map.put("Xiao Ming",s);
        Student target = map.get("Xiao Ming");
        System.out.println(s);
        System.out.println(target == s);
        System.out.println(target.score);
        Student another = map.get("Bob");
        System.out.println(another);
        System.out.println(s.toString());

    }
}

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
