package weather.com.weatherapp.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherJSON {
    @Expose
    @SerializedName("coord")
    public Coordinates coordinates;

    @Expose
    @SerializedName("main")
    public MainData mainData;

    @Expose
    @SerializedName("wind")
    public Wind wind;

    @Expose
    @SerializedName("name")
    public String nameOfCity;



    public class Coordinates {

        @Expose
        @SerializedName("lon")
        public float longitude;

        @Expose
        @SerializedName("lat")
        public float latitude;
    }

    public class MainData {
        @Expose
        @SerializedName("temp")
        public float temperature;

        @Expose
        @SerializedName("pressure")
        public int pressure;

        @Expose
        @SerializedName("humidity")
        public int humidity;

        @Expose
        @SerializedName("temp_min")
        public float minTemp;

        @Expose
        @SerializedName("temp_max")
        public float maxTemp;
    }

    public class Wind {
        @Expose
        @SerializedName("speed")
        public float speed;
    }
}