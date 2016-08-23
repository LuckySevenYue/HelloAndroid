package android.news.com.yapplication.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yy10017 on 2016/8/23.
 * 展示小型UI工具类（如：Toast）
 */

public class Uikit {

    public static void showToast(Context context, String msg){
        Toast.makeText(null,msg,Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String msg){
        Toast.makeText(null,msg,Toast.LENGTH_LONG).show();
    }

}
