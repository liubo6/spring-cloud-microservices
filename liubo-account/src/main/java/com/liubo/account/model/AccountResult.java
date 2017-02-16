package com.liubo.account.model;

import java.io.Serializable;

/**
 * Created by hzlbo on 2017/2/16 0016.
 */
public class AccountResult implements Serializable {
    private boolean result;
    private String code;
    private String msg;
    private Object content;

    public AccountResult(boolean result) {
        this.result = result;
    }

    public static AccountResult falseResult(String msg) {
        AccountResult accountResult = new AccountResult(false);
        accountResult.setMsg(msg);
        return accountResult;
    }

    public static AccountResult trueResult(String msg) {
        AccountResult accountResult = new AccountResult(true);
        accountResult.setMsg(msg);
        return accountResult;
    }

    public static AccountResult trueResult(String msg, Object content) {
        AccountResult accountResult = new AccountResult(true);
        accountResult.setMsg(msg);
        accountResult.setContent(content);
        return accountResult;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AccountResult{" +
                "result=" + result +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}
