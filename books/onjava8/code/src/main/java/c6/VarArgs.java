package c6;

class A {
}

public class VarArgs {
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.println(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 1
//        printArray(new Object[]{47, (float) 3.14, 11.11});
//        printArray(new Object[]{"one", "two", "three"});
//        printArray(new Object[]{new A(), new A(), new A()});
        //2
        printArray(47, (float) 3.14, 11.11);
        printArray(47, 3.14F, 11.11);
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A());
        printArray((Object[]) new Integer[]{1, 2, 3, 4});
        printArray();
    }
}
