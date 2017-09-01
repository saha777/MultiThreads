package thread.communication;

public class NamedConsumer implements Runnable{
    Producer producer;
    String name;

    public NamedConsumer(Producer producer, String name) {
        this.producer = producer;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            String message = producer.getMessage();
            System.out.println(name + ": " + message);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){}
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        new Thread(producer).start();
        NamedConsumer namedConsumer = new NamedConsumer(producer, "One");
        new Thread(namedConsumer).start();
        Consumer consumer = new Consumer(producer);
        new Thread(consumer).start();
    }
}
