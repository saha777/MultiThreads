import java.applet.Applet;
import java.awt.*;

public class UpdateApplet extends Applet implements Runnable{
    Thread thread;
    boolean running;
    int updateInterval = 1000;
    @Override
    public void run() {
        while (running){
            repaint();
            try {
                Thread.sleep(updateInterval);
            }catch (InterruptedException e){
                System.out.println("Iterrupted ...");
                return;
            }
        }
    }

    public void start(){
        System.out.println("Starting ...");
        if(!running){
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop(){
        System.out.println("Stopping ...");
        thread.interrupt();
        running = false;
    }
}
