package totchi.g3an.data.remote.model.showOrders;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Medhat on 29/08/2018.
 */

public class showOrdersResponse extends GenralResponse<List<showOrdersResponse>> {

    @SerializedName("id")
    private int id;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("address")
    private String address;
    @SerializedName("plateName")
    private String plateName;
    @SerializedName("userName")
    private String userName;
    @SerializedName("chiefName")
    private String chiefName;
    @SerializedName("chiefId")
    private int chiefId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public int getChiefId() {
        return chiefId;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }
}
