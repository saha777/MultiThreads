package thread.exchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable{
    Exchanger<String> exchanger;
    String message;

    public PutThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Hello, ";
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.print(message);
        }catch (InterruptedException ex){}
    }
}
