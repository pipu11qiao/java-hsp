package needExercise;

interface IntCall {
    int call(int n);
}

public class RecursiveDemo {
    static IntCall fun;

    public static void main(String[] args) {
        fun = (int n) -> n == 1 ? 1 : n * fun.call(n - 1);
        System.out.println(fun.call(4));
    }
}
