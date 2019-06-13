package totchi.g3an.data.remote.model.addNewOrder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medhat on 29/08/2018.
 */

public class addOrderRequest {

    @SerializedName("plate_id")
   private int plate_id;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("address")
    private String address;

    public addOrderRequest(int plate_id, int user_id, int quantity, String address) {
        this.plate_id = plate_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.address = address;
    }

    public addOrderRequest() {
    }

    public int getPlate_id() {
        return plate_id;
    }

    public void setPlate_id(int plate_id) {
        this.plate_id = plate_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
