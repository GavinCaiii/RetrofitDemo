package com.caitou.retrofitdemo.module.main;

import com.caitou.retrofitdemo.http.response.WeatherInfo;

/**
 * @className: MainPresent
 * @classDescription: 业务逻辑处理层
 * @Author: Guangzhao Cai
 * @createTime: 2016-08-10.
 */
public class MainPresent implements MainModel.ModelListener {
    private PresentListener mListener;
    private MainModel mMainModel;

    public MainPresent(PresentListener listener) {
        mListener = listener;
        mMainModel = new MainModel(this);
    }

    public void getWeatherInfo() {
        if (mMainModel != null) {
            mMainModel.requestData("广州");
        }
    }

    @Override
    public void callBackResponse(WeatherInfo weatherInfo) {
        mListener.callBackResponse(weatherInfo);
    }

    public interface PresentListener {
        void callBackResponse(WeatherInfo response);
    }
}
