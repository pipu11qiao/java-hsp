import java.util.ArrayList;
import java.util.List;

// add(E e) add(int index,E e) remove(int index) remove(Object e) get(int index) size
// ArrayList LinkedList

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add(null);
        list.add("pear");
        list.add("apple");
        System.out.println(list.toString());
    }
}