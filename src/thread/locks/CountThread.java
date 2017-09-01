package thread.locks;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable{
    CommonResource res;
    ReentrantLock locker;

    public CountThread(CommonResource res, ReentrantLock locker) {
        this.res = res;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try{
            res.x = 1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException ex){}
        finally{locker.unlock();}
    }
}
