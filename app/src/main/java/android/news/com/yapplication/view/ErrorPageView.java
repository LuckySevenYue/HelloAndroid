package android.news.com.yapplication.view;

import android.content.Context;
import android.news.com.yapplication.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by yy10017 on 2016/9/4.
 * 错误页展示
 * 网络错误 和  数据异常
 */

public class ErrorPageView extends RelativeLayout {

    private View mRootView;

    public ErrorPageView(Context context) {
        this(context, null);
    }

    public ErrorPageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ErrorPageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        mRootView = LayoutInflater.from(context).inflate(R.layout.err_page, this);
    }
}
