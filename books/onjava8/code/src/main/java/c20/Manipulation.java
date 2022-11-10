package c20;

class Manipulator<T extends HasF> {

    private T obj;

    Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }

}

public class Manipulation<T> {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }

}
