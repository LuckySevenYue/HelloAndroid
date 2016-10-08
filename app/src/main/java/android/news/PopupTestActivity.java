package android.news;

import android.graphics.drawable.Drawable;
import android.news.base.BaseActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by yue10017 on 2016/10/8.
 * 测试 PopUpWindow
 */

public class PopupTestActivity extends BaseActivity {

    private LayoutInflater inflater;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(this);
        textView = getView(R.id.tv_hello);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        popView();
    }

    private void popView() {
        View view = inflater.inflate(R.layout.activity_main3, null);
        PopupWindow window = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_two));
        if (window.isShowing()){
            window.dismiss();
        } else {
            window.showAsDropDown(textView);
        }
    }


}
