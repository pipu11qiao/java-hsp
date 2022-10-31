package c9;

public class Shapes {
    public static void main(String[] args) {
        RandomShapes gen = new RandomShapes();

        for (Shape shape : gen.array(9)) {
            shape.draw();
        }
    }
}
