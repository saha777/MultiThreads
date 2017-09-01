package thread.lockconditions;

public class ConditionRunner {
    //await: поток ожидает, пока не будет выполнено некоторое условие
    // и пока другой поток не вызовет методы signal/signalAll.
    // Во многом аналогичен методу wait класса Object

    //signal: сигнализирует, что поток, у которого ранее был вызван метод await(),
    // может продолжить работу. Применение аналогично использованию методу notify класса Object

    //signalAll: сигнализирует всем потокам, у которых ранее был вызван метод await(),
    // что они могут продолжить работу. Аналогичен методу notifyAll() класса Object

    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
