package weather.com.weatherapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import weather.com.weatherapp.R;
import weather.com.weatherapp.responses.WeatherJSON;

public class ShowWeatherActivity extends AppCompatActivity {

    static WeatherJSON response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weather);

        TextView lati = getEdit(R.id.lati);
        TextView longi= getEdit(R.id.longi);
        TextView temp = getEdit(R.id.temp);
        TextView pressure = getEdit(R.id.pressure);
        TextView humidity = getEdit(R.id.humidity);
        TextView minT= getEdit(R.id.minT);
        TextView maxT = getEdit(R.id.maxT);
        TextView wind = getEdit(R.id.windSpeed);
        TextView nameOfCity= getEdit(R.id.cityname);

        lati.setText(""+response.coordinates.latitude);
        longi.setText(""+response.coordinates.longitude);
        String tempInDegreeCelsius = String.valueOf(response.mainData.temperature-273);
        temp.setText(tempInDegreeCelsius);
        pressure.setText(""+response.mainData.pressure+" atm");
        humidity.setText(""+response.mainData.humidity+"%");
        String minTemp = String.valueOf(response.mainData.minTemp-273);
        minT.setText(minTemp);
        String maxTemp= String.valueOf(response.mainData.maxTemp-273);
        maxT.setText(maxTemp);
        wind.setText(""+response.wind.speed+" km/h");
        nameOfCity.setText(response.nameOfCity);

    }

    private TextView getEdit(int id){
        return (TextView) findViewById(id);
    }
}
