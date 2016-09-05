package android.news;

import android.content.Intent;
import android.news.base.BaseActivity;
import android.news.entity.req.LoginReqBody;
import android.news.net.RequestObject;
import android.news.util.Uikit;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yy10017 on 2016/9/4.
 * 登录页
 */

public class LoginActivity extends BaseActivity {

    private String account = "";
    private String pwd = "";

    private EditText mAccountEt, mPwdEt;
    private Button mLoginBtn;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        initView();
    }

    private void initView() {
        mAccountEt =  getView(R.id.et_account);
        mPwdEt = getView(R.id.et_password);
        mLoginBtn = getView(R.id.btn_login);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginBtn){
            if (checkInput()){
                toLoginClient(account, pwd);
            }
        }
    }

    private boolean checkInput(){
        account = mAccountEt.getText().toString().trim();
        pwd = mPwdEt.getText().toString().trim();
        if (TextUtils.isEmpty(account)){
            Uikit.showToast("账号为空");
            return false;
        }
        if (TextUtils.isEmpty(pwd)){
            Uikit.showToast("密码为空");
            return false;
        }
        return false;
    }


    private void toLoginClient(final String account, final String pwd) {

        /*LoginReqBody reqBody = new LoginReqBody();
        reqBody.setAccount(account);
        reqBody.setPwd(pwd);
        sendRequest(new RequestObject("", reqBody));
        */

        if (account.contains("yue") || pwd.contains("yue")){   //login success!
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Uikit.showToast("登录成功!");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 2000);
        } else {
            Uikit.showToast("登录账号或密码不正确!");
        }
    }
}
