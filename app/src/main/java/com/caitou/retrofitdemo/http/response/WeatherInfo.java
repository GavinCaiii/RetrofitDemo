package com.caitou.retrofitdemo.http.response;

import java.util.ArrayList;

/**
 * @className: WeatherInfo
 * @classDescription: retrofit返回数据的bean
 * @Author: Guangzhao Cai
 * @createTime: 2016-08-10.
 */
public class WeatherInfo {

    public String reason;
    public Result result;
    public String error_code;

    public class Result {
        public Data data;

        public class Data {
            public RealTime realtime;
            public ArrayList<Weather> weather;
            public Pm25 pm25;

            public class RealTime {
                // 更新时间
                public String dataUptime;
                // 当前实况天气
                public Weather weather;
                // 当前日期
                public String date;
                // 当前城市名字
                public String city_name;
                // 星期
                public int week;
                // 农历
                public String moon;

                public class Weather {
                    // 湿度
                    public String humidity;
                    // 天气描述
                    public String info;
                    // 当前温度
                    public String temperature;
                }
            }
            public class Weather {
                public String date;
                public String week;
                public String nongli;
                public Info info;
                public class Info {
                    public ArrayList<String> night;
                    public ArrayList<String> day;
                }
            }

            public class Pm25 {
                public PM25 pm25;
                public class PM25 {
                    // 空气质量
                    String quality;
                    // 空气描述
                    String des;
                }
            }

        }
    }
}
