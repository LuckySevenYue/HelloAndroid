package android.news.util;

import android.util.Log;

/**
 * Created by yy10017 on 2016/8/22.
 * Print Log
 */

public class LogCat {

    public static void i(String tag, String msg){
        Log.i(tag,msg);
    }

    public static void e(String tag, String msg){
        Log.e(tag,msg);
    }

    public static void printf(String tag, String format, Object... args){
        Log.e(tag, String.format(format, args));
    }

    public static void i(Class clazz, String msg){
        Log.i(clazz.getSimpleName(), msg);
    }

    public static void e(Class clazz, String msg){
        Log.e(clazz.getSimpleName(), msg);
    }

    public static void printf(Class clazz, String format, Object... args){
        Log.e(clazz.getSimpleName(), String.format(format, args));
    }
}
