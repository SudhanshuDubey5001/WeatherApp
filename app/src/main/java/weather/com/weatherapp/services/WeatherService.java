package weather.com.weatherapp.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weather.com.weatherapp.responses.WeatherJSON;

public interface WeatherService {

    public static final String API_KEY = "23ad1a872277778001ccf6f7c6fbe78a";

    @GET("data/2.5/weather")
    Call<WeatherJSON> getJSONweather(@Query("q") String cityName,@Query("APPID") String apiKey);
}
