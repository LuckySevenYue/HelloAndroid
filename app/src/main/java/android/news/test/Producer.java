package android.news.test;

/**
 * Created by yy10017 on 2016/9/9.
 * 生产者
 */

public class Producer extends Thread{

    private Storage storage;
    private int num;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    private void produce(int num){
        storage.produce(num);
    }

    @Override
    public void run() {
        produce(num);
    }

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }
}
