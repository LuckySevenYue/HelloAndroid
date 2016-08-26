package android.news.com.yapplication.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yy10017 on 2016/8/22.
 * 这个类用来测试
 */

public class Test {

    public static final int INT = 16;

    public static void main(String []args){
        // TODO: 2016/8/22
        Map<String, String> map = new LinkedHashMap<>(16,0.75f,true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "e");

        map.get("1");
        map.get("2");

        for (Iterator<String> iterator = map.values().iterator(); iterator.hasNext();) {
            String name = iterator.next();
            System.out.print(name);
        }}
}
