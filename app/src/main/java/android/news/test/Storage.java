package android.news.test;

import java.util.LinkedList;

/**
 * Created by yy10017 on 2016/9/9.
 * 代理类
 */

class Storage {

    private static final int STORAGE_MAX = 100;

    private LinkedList<Object> objList = new LinkedList<>();

    void produce(int sum) {

        synchronized (objList) {
            while (objList.size() + sum > STORAGE_MAX) {
                System.out.println("【现有库存量】" + objList.size() + "/t【要生产】" + sum + "/t【暂时不能执行生产任务】");
                try {
                    objList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < sum; i++) {
                objList.add(new Object());//生产
            }
            System.out.println("【已经生产】" + sum + "/t【现有库存量】" + objList.size());
            objList.notifyAll();
        }
    }

    void consume(int sum) {
        while (objList.size() < sum) {
            System.out.println("【现有库存量】" + objList.size() + "/t【要消费】" + sum + "/t【暂时不能执行消费任务】");
            try {
                objList.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < sum; i++) {
            objList.remove();//消费
        }
        System.out.println("【已经消费】" + sum + "/t【现有库存量】" + objList.size());
        objList.notifyAll();
    }

}
