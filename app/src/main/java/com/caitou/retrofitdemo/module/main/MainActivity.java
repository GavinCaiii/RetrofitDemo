package com.caitou.retrofitdemo.module.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.caitou.retrofitdemo.R;
import com.caitou.retrofitdemo.http.response.WeatherInfo;
import com.caitou.retrofitdemo.utils.DateUtil;
import com.caitou.retrofitdemo.utils.LogUtil;

public class MainActivity extends AppCompatActivity implements MainPresent.PresentListener{
    private Button getData;

    private MainPresent mMainPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresent = new MainPresent(this);

        getData = (Button) findViewById(R.id.get_data);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPresent.getWeatherInfo();
            }
        });
    }

    @Override
    public void callBackResponse(WeatherInfo weatherInfo) {

        LogUtil.d(weatherInfo.result.data.realtime.city_name);
        LogUtil.d("----------------------------------------------------");
        LogUtil.d("当前温度温度  " + weatherInfo.result.data.realtime.weather.temperature + "°");
        LogUtil.d("天气  " + weatherInfo.result.data.realtime.weather.info);
        LogUtil.d(DateUtil.getTime(weatherInfo.result.data.realtime.dataUptime) + " 更新");

        for (WeatherInfo.Result.Data.Weather weather : weatherInfo.result.data.weather) {

            String dayWeather;
            String dayTemperature;
            String nightWeather;
            String nightTemperature;

            dayWeather = weather.info.day.get(1);
            dayTemperature = weather.info.day.get(2);
            nightWeather = weather.info.night.get(1);
            nightTemperature = weather.info.night.get(2);

            LogUtil.d(weather.date + "  星期" + weather.week);
            LogUtil.d("农历 " + weather.nongli);

            LogUtil.d("白天天气：" + dayWeather);
            LogUtil.d("夜晚天气：" + nightWeather);
            LogUtil.d("温度：" + nightTemperature + " ～　" + dayTemperature);
            LogUtil.d("----------------------------------------------------");
        }
    }
}
