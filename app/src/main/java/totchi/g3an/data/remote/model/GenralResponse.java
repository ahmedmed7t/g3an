package totchi.g3an.data.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fatma on 06/07/2018.
 */

public class GenralResponse<T extends Object> {
    @SerializedName("status")
    boolean status;
    @SerializedName("error")
    String error;
    @SerializedName("data")
    T data;

    public boolean isStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public T getData() {
        return data;
    }


}
