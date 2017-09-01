package thread.communication;

public class Consumer implements Runnable{
    Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            String message = producer.getMessage();
            System.out.println(message);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ex){}

        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        new Thread(producer).start();
        Consumer consumer = new Consumer(producer);
        new Thread(consumer).start();
    }
}
