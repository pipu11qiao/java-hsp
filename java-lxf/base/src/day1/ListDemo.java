package day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// add(E e) add(int index,E e) remove(int index) remove(Object e) get(int index) size
// ArrayList LinkedList

public class ListDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("apple");
//        list.add(null);
//        list.add("pear");
//        list.add("apple");
//        System.out.println(list.toString());
//        List<Integer> list = List.of(1, 2, 5);
//        List<String> list = List.of("apple", "pear", "banana");
//        for (Iterator<String> it = list.iterator(); it.hasNext();) {
//            String s = it.next();
//            System.out.println(s);
//        }
//        Object[] array = list.toArray();
//        for (Object s : array) {
//            System.out.println(s);
//        }
//        List<Integer> list = List.of(1, 32, 3543);
//        Integer[] array = list.toArray(new Integer[3]);
//        for (Integer n : array) {
//            System.out.println(n);
//        }
        List<Integer> list = List.of(135, 32, 3543);
        Number[] array = list.toArray(new Number[3]);
        for (Number n : array) {
            System.out.println(n);
        }
    }
}