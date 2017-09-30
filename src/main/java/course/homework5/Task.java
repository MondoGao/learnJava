package course.homework5;

import java.util.LinkedList;

public class Task {
    private LinkedList<Object> packages = new LinkedList<>();
    private static int capacity = 5;

    public static void run() {
        Task t = new Task();

        new Thread(() -> t.getPackage()).start();
        new Thread(() -> t.putPackage(1)).start();
    }

    public synchronized void getPackage() {
        while (packages.size() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(packages.pop());
        notify();
    }

    public synchronized void putPackage(Object p) {
        while (packages.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        packages.push(p);
        notify();
    }
}
