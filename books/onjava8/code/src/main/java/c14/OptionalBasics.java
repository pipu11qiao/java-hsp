package c14;

import java.util.*;
import java.util.stream.*;

public class OptionalBasics {
    static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }
}
