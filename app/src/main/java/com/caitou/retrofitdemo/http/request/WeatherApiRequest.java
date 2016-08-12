package com.caitou.retrofitdemo.http.request;

import com.caitou.retrofitdemo.AppContext;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @className:
 * @classDescription:
 * @Author: Guangzhao Cai
 * @createTime: 2016-08-10.
 */
public class WeatherApiRequest {
    private Retrofit retrofit;

    private static WeatherApiRequest instance;

    private WeatherApiRequest() {}

    public static WeatherApiRequest getInstance() {
        if (instance == null)
            instance = new WeatherApiRequest();
        return instance;
    }

    public <T> T create(Class<T> service) {
        retrofit = new Retrofit.Builder()
                .baseUrl(AppContext.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }
}
