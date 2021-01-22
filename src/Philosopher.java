import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    static private Lock lock = new ReentrantLock();
    Chopstick left;
    Chopstick right;
    String name;
    public Philosopher(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    // try to pick up left and right chopsticks;
    // return true if success (if left and right chopsticks is free)
    public boolean pickUp() {
        lock.lock();
        try {
            if (left.take())
                if (right.take()) {
                    return true;
                }
                else
                    left.put();
                return false;
        } finally {
            lock.unlock();
        }
    }

    // to put down chopsticks
    public void putDown() {
        left.put();
        right.put();
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // try to pick up chopsticks; if it`s free then philosopher can eat
                // else he waits for their release
                if (pickUp()) {
                    System.out.println(this + " eating");
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));
                    putDown();
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));
                    System.out.println(this + " ate");
                    System.out.println(this + " thinking");
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));
                } else {
                    System.out.println(this + " thinking");
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5000));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupt");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
