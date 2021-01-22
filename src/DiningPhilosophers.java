import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {
        // num of philosophers and their chopsticks
        int size = 5;
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < 5; i++)
            chopsticks[i] = new Chopstick();
        String[] names = new String[] { "Sokrat", "Aristotel", "Ciceron", "Pifagor", "Diogen" };
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(chopsticks[i], chopsticks[(i+1) % size], names[i]));
        }
        // to exit press any button
        System.in.read();
        exec.shutdownNow();
    }
}
