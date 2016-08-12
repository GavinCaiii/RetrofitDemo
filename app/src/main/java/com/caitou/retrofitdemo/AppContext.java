package com.caitou.retrofitdemo;

import android.app.Application;
import android.util.Log;

import com.caitou.retrofitdemo.utils.LogUtil;

/**
 * @className:
 * @classDescription:
 * @Author: Guangzhao Cai
 * @createTime: 2016-08-10.
 */
public class AppContext extends Application {

    public static final String BASE_URL = "http://op.juhe.cn/";
    public static final String APP_KEY = "a2da70728aa47f71edd6411ec13021f5";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true, Log.VERBOSE);
    }
}
