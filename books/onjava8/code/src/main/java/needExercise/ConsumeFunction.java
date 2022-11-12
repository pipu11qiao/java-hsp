package needExercise;

import java.util.function.Function;

// 高阶函数
class One {
    @Override
    public String toString() {
        return "one";
    }
}

class Two {
    @Override
    public String toString() {
        return "two";
    }
}

public class ConsumeFunction {
    static Two consume(Function<One, Two> oneTwo) {
        return oneTwo.apply(new One());

    }

    public static void main(String[] args) {
        Two two = consume(h -> new Two());

    }

}
