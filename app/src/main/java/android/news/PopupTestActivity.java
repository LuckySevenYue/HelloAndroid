package android.news;

import android.news.base.BaseActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
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
    private boolean isShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(this);
        textView = getView(R.id.tv_hello);
        String text = "abcdefg\nabcdefg\nbbb\nabcdefg";
        String light = "bbb";
        SpannableStringBuilder mTipsBuilder = new StringFormatBuilder(text, light)
                .buildColor(getResources().getColor(R.color.main_green)).getResult();
        textView.setText(mTipsBuilder);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        isShowing = !isShowing;
        popView();
    }

    private void popView() {
        View view = inflater.inflate(R.layout.activity_main3, null);
        PopupWindow window = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_two));
        if (isShowing){
            window.dismiss();
        } else {
            window.showAsDropDown(textView);
        }
    }


}
