package thread.semaphore;

import java.util.concurrent.Semaphore;

public class PhilosopherRunner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 1; i < 6; i++){
            new Philosopher(semaphore, i).run();
        }
    }
}
