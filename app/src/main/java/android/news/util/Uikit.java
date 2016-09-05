package android.news.util;

import android.content.Context;
import android.news.base.HelloApplication;
import android.widget.Toast;

/**
 * Created by yy10017 on 2016/8/23.
 * 展示小型UI工具类（如：Toast）
 */

public class Uikit {

    public static void showToast(String msg){
        Toast.makeText(HelloApplication.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String msg){
        Toast.makeText(HelloApplication.getInstance().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

}
