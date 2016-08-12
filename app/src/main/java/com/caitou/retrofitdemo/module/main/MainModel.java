package com.caitou.retrofitdemo.module.main;

import com.caitou.retrofitdemo.AppContext;
import com.caitou.retrofitdemo.http.request.WeatherApiRequest;
import com.caitou.retrofitdemo.http.request.api.ApiData;
import com.caitou.retrofitdemo.http.response.WeatherInfo;
import com.caitou.retrofitdemo.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @className: MainModel
 * @classDescription: 数据层
 * @Author: Guangzhao Cai
 * @createTime: 2016-08-10.
 */
public class MainModel {
    private ApiData mApiData;
    private ModelListener mListener;
    private Gson gson;

    public MainModel(ModelListener listener) {
        gson = new GsonBuilder().create();
        mListener = listener;
    }

    /**
     * 请求数据
     */
    public void requestData(String cityName) {

        mApiData = WeatherApiRequest.getInstance().create(ApiData.class);
        Call<WeatherInfo> callWeatherInfo = mApiData.getWeatherInfo(cityName, AppContext.APP_KEY);

        callWeatherInfo.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                WeatherInfo weatherInfo = response.body();

                mListener.callBackResponse(weatherInfo);
            }
            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                LogUtil.e("请求失败");
            }
        });
    }

    public interface ModelListener {
        void callBackResponse(WeatherInfo weatherInfo);
    }
}
