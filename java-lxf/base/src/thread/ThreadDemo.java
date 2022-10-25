package thread;

public class ThreadDemo {
    public static void main(String[] args) {
//        Thread t = new MyThread();
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread throw class!");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread throw runnable!");
    }
}
