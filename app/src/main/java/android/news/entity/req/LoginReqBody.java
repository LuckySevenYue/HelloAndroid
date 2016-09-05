package android.news.entity.req;

import java.io.Serializable;

/**
 * Created by yy10017 on 2016/9/5.
 * 登录请求体
 */

public class LoginReqBody implements Serializable {

    private String account;

    private String pwd;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
