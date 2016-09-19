package android.news.test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yy10017 on 2016/9/12.
 * 日历测试
 */

public class LunarTest {

    public static void main(String []args){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1993,9,13);
        Lunar lunar = new Lunar(calendar);
        System.out.println(lunar.toString());
    }
}
