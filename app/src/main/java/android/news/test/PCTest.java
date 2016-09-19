package android.news.test;

/**
 * Created by yy10017 on 2016/9/9.
 * 生产者 - 消费者测试
 */

public class PCTest {

    public static void main(String []args){
        Storage storage = new Storage();

        Producer pro_1 = new Producer(storage);
        Producer pro_2 = new Producer(storage);
        Producer pro_3 = new Producer(storage);
        Producer pro_4 = new Producer(storage);
        Producer pro_5 = new Producer(storage);
        Producer pro_6 = new Producer(storage);
        Producer pro_7 = new Producer(storage);

        Consumer con_1 = new Consumer(storage);
        Consumer con_2 = new Consumer(storage);
        Consumer con_3 = new Consumer(storage);
        Consumer con_4 = new Consumer(storage);
        Consumer con_5 = new Consumer(storage);
        Consumer con_6 = new Consumer(storage);
        Consumer con_7 = new Consumer(storage);

        pro_1.setNum(10);
        pro_2.setNum(10);
        pro_3.setNum(10);
        pro_4.setNum(10);

        con_1.setNum(20);
        con_2.setNum(10);
        con_3.setNum(20);

        con_1.start();
        con_2.start();
        pro_1.start();
        pro_2.start();
        pro_3.start();
        pro_4.start();
    }
}
