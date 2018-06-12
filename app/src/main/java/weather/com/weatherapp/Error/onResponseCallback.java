package weather.com.weatherapp.Error;


import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class onResponseCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            Gson gson = new Gson();
            try {
                ApiError error = gson.fromJson(response.errorBody().string(), ApiError.class);
                onFail(error);
            } catch (IOException e) {
                onFail(new ApiError(500,"Unknown error"));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFail(new ApiError(500,t.getMessage()));
    }
    abstract public void onSuccess(T response);

    abstract public void onFail(ApiError error);

}
