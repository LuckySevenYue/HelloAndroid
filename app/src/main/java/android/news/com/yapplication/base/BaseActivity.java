package android.news.com.yapplication.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by yy10017 on 2016/8/23.
 * base
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    public final <V extends View> V getView(int id) {
        try {
            return (V) findViewById(id);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

}
