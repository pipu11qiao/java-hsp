package c19.classes;

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;

        bounded = double.class;
        bounded = Number.class;

    }
}
