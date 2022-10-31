class A {
};

public class VarArgs {
    static void printArray(Object[] args) {
        for (Object obj : args) {
            System.out.println(obj + "");
        }
        System.out.println();
    }
}