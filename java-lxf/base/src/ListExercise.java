import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// add(E e) add(int index,E e) remove(int index) remove(Object e) get(int index) size
// ArrayList LinkedList

public class ListExercise {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        Integer left = start;
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Integer right = it.next();
            if (right - left > 1) {
                return right - 1;
            }
            left = right;
        }
        return end - 1;
    }
}

