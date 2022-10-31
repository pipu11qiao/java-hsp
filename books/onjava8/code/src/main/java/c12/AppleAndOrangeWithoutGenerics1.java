package c12;


import java.util.ArrayList;

public class AppleAndOrangeWithoutGenerics1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
//            apples.add(new Orange());
            for (Object apple : apples) {
                ((Apple) apple).id();
            }
        }
    }
}
