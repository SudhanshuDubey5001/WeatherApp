package weather.com.weatherapp.Error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiError {

    @Expose
    @SerializedName("cod")
    public int errorCode;

    @Expose
    @SerializedName("message")
    public String message;

    public ApiError(int errorCode,String message){
        this.message=message;
        this.errorCode=errorCode;
    }
}
