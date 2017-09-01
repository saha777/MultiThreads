package thread.communication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Producer implements Runnable{
    final static int MAXQUEUE = 5;
    private List messages = new ArrayList();

    @Override
    public void run() {
        while(true){
            putMessage();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){}
        }
    }

    private synchronized void putMessage(){
        while (messages.size() > MAXQUEUE){
            try{
                wait();
            }catch (InterruptedException ex){}
        }
        messages.add(new Date().toString());
        notify();
    }

    public synchronized String getMessage(){
        while(messages.size() == 0){
            try{
                notify();
                wait();
            }catch (InterruptedException ex){}
        }
        String message = (String) messages.remove(0);
        notify();
        return message;
    }
}
