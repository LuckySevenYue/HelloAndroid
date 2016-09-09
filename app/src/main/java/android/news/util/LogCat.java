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

    public static void formatPrintf(String tag, String format, Object... args){
        Log.e(tag,String.format(format,args));
    }
}
