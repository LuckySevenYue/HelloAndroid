package android.news.test;

/**
 * Created by yy10017 on 2016/9/9.
 * 生产者
 */

class Consumer extends Thread {

    private Storage storage;

    private int num;

    Consumer(Storage storage) {
        this.storage = storage;
    }

    private void consume(int sum) {
        storage.consume(sum);
    }

    @Override
    public void run() {
        consume(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
