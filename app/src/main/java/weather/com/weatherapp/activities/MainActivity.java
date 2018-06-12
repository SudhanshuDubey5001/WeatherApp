package weather.com.weatherapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kaopiz.kprogresshud.KProgressHUD;

import weather.com.weatherapp.Error.ApiError;
import weather.com.weatherapp.Error.onResponseCallback;
import weather.com.weatherapp.R;
import weather.com.weatherapp.WeatherBuilder;
import weather.com.weatherapp.responses.WeatherJSON;
import weather.com.weatherapp.services.WeatherService;

public class MainActivity extends AppCompatActivity {

    EditText cityName;

    public static KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.nameOfCity);
        Button button = (Button) findViewById(R.id.submit);

        hud = new KProgressHUD(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Hold on")
                .setCancellable(true)
                .setAnimationSpeed(3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cityName.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Error")
                            .setMessage("Come..on man..enter something")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).show();
                } else {
                    hud.show();
                    WeatherBuilder.build().getJSONweather(cityName.getText().toString(), WeatherService.API_KEY)
                            .enqueue(new onResponseCallback<WeatherJSON>() {
                                @Override
                                public void onSuccess(WeatherJSON response) {
                                    Intent in = new Intent(MainActivity.this, ShowWeatherActivity.class);
                                    ShowWeatherActivity.response = response;
                                    hud.dismiss();
                                    startActivity(in);
                                }

                                @Override
                                public void onFail(ApiError error) {
                                    hud.dismiss();
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setTitle("Error")
                                            .setMessage(error.message+"(" + error.errorCode + ")")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    dialogInterface.dismiss();
                                                    MainActivity.this.finish();
                                                }
                                            }).show();

                                }
                            });
                }
            }
        });
    }
}
