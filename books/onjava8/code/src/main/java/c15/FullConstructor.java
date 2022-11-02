package c15;

import org.w3c.dom.ls.LSOutput;

class MyException extends Exception {
    MyException() {
    }

    MyException(String msg) {
        super(msg);
    }
}

public class FullConstructor {
    public static void f() throws MyException {
        System.out.println("exe from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("exe from g()");
        throw new MyException("g");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
