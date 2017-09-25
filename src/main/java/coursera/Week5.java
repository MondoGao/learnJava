package coursera;

import java.util.LinkedList;
import java.util.Queue;

public class Week5 {
    public static void main(String... args) {
        TransferQueue queue = new TransferQueue();

        queue.add(new Bird("Bob"));
        queue.add(new Bird("Jack"));
        queue.add(new Bird("John"));

        queue.run();
    }
}

interface Flyable {
    void fly();
}

interface Transferable {
    default void transfer(Transferable t) {
        t.run();
    }
    void run();
}

class TransferQueue {
    Queue<Transferable> q = new LinkedList<>();

    public void add(Transferable t) {
        q.add(t);
    }

    public void run() {
        Transferable current = q.poll();

        if (current != null) {
            current.run();

            for (Transferable next = q.poll(); next != null; next = q.poll()) {
                current.transfer(next);
                current = next;
            }
        }

        System.out.println("Flying queue finished! Congratulations!");
    }
}

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Bird extends Animal implements Flyable, Transferable {
    @Override
    public void fly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " is Flying");
    }

    @Override
    public void run() {
        this.fly();
    }

    public Bird(String name) {
       super(name);
    }
}