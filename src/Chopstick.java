public class Chopstick {
    private boolean taken = false;

    // to take chopstick, return true if success (if chopstick is free)
    public boolean take() {
        if (!taken) {
            taken = true;
            return true;
        }
        return false;
    }

    public void put() {
        taken = false;
    }
}
