package weather.com.weatherapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.com.weatherapp.services.WeatherService;

public class WeatherBuilder {

    public static WeatherService build(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(getBaseURL())
               .addConverterFactory(GsonConverterFactory.create())
               .build();

        return retrofit.create(WeatherService.class);
    }


    static String getBaseURL(){
        return "http://api.openweathermap.org/";
    }
}
