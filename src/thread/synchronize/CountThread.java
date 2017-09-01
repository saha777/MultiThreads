package thread.synchronize;

public class CountThread implements Runnable{
    CommonResource res;

    public CountThread(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res){
            res.x = 1;
            for(int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ex){}
            }
        }
    }
}
