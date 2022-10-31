package c13;

public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        int res = fact.call(4);
        System.out.println(res);
    }
}
