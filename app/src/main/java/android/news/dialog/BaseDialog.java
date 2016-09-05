package android.news.dialog;

import android.app.Dialog;
import android.content.Context;
import android.news.R;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by yy10017 on 2016/9/5.
 * the baseClass of Dialog
 */

public class BaseDialog extends Dialog implements View.OnClickListener {

    private ProgressBar mLoadingPb;
    private TextView mLoadingTv;
    private ImageView mLoadingIv;

    public BaseDialog(Context context) {
        super(context, R.style.MessageLoadingBox);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        if (window != null){
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        setContentView(R.layout.progress_bar);
        initView();
    }

    private void initView() {
        mLoadingPb = (ProgressBar) findViewById(R.id.center_process_bar);
        mLoadingTv = (TextView) findViewById(R.id.tv_process_prompt);
        mLoadingIv = (ImageView) findViewById(R.id.iv_cancel);
        mLoadingIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoadingIv){
            // TODO: 2016/9/5  
        }
    }
}
