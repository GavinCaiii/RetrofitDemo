package com.caitou.retrofitdemo.http.request.api;

import com.caitou.retrofitdemo.http.response.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @className:
 * @classDescription:
 * @Author: Guangzhao Cai
 * @createTime: 2016-08-10.
 */
public interface ApiData {

    // 获取天气信息
    @FormUrlEncoded
    @POST("onebox/weather/query")
    Call<WeatherInfo> getWeatherInfo(
            @Field("cityname") String cityName,
            @Field("key") String key
    );
}
