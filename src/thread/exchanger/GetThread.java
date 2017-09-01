package thread.exchanger;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable{
    Exchanger<String> exchanger;
    String message;

    public GetThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "world!";
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.print(message);
        }catch (InterruptedException ex){}
    }
}
