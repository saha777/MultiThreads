package thread.wan;

public class Store {
    private int products = 0;
    public synchronized void get(){
        while(products < 1){
            try{wait();}catch (InterruptedException ex){}
        }
        products--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + products);
        notify();
    }
    public synchronized void put(){
        while (products >= 3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        products++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + products);
        notify();
    }
}
