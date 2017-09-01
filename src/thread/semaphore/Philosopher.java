package thread.semaphore;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private Semaphore semaphore;
    private int num = 0;
    private int id;

    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try{
            while (num < 3){
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");

                sleep(500);
                num++;

                System.out.println ("Философ " + id+" выходит из-за стола");
                semaphore.release();

                sleep(700);
            }
        }catch (InterruptedException ex){}
    }
}
