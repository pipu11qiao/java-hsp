package c20;

import java.util.List;
import java.util.function.Supplier;

public class Suppliers {
    static void fill(List list, Supplier gen, int size) {
        for (int i = 0; i < size; i++) {
            list.add(gen.get());
        }
    }
}
