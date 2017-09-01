package thread.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockRunner {
    //void lock(): ожидает, пока не будет получена блокировка

    //boolean tryLock(): пытается получить блокировку, если блокировка получена,
    //то возвращает true. Если блокировка не получена,
    // то возвращает false. В отличие от метода lock()
    // не ожидает получения блокировки, если она недоступна

    //void unlock(): снимает блокировку

    //Condition newCondition(): возвращает объект Condition, который связан с текущей блокировкой

    public static void main(String[] args) {
        CommonResource commonResource= new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Поток "+ i);
            t.start();
        }
    }
}
