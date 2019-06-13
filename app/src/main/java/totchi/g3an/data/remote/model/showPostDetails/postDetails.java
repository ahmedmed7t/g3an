package totchi.g3an.data.remote.model.showPostDetails;

import com.google.gson.annotations.SerializedName;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Medhat on 29/08/2018.
 */

public class postDetails extends GenralResponse<postDetails> {

    @SerializedName("id")
    private int id;
    @SerializedName("chiefName")
    private String chiefName;
    @SerializedName("chiefImage")
    private String chiefImage;
    @SerializedName("plateImage")
    private String plateImage;
    @SerializedName("plateName")
    private String plateName;
    @SerializedName("price")
    private int price;
    @SerializedName("time")
    private String time;
    @SerializedName("description")
    private String descreption;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public String getChiefImage() {
        return chiefImage;
    }

    public void setChiefImage(String chiefImage) {
        this.chiefImage = chiefImage;
    }

    public String getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(String plateImage) {
        this.plateImage = plateImage;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public postDetails(String chiefName, String chiefImage, String plateImage, String plateName, int price, String time, String descreption) {
        this.chiefName = chiefName;
        this.chiefImage = chiefImage;
        this.plateImage = plateImage;
        this.plateName = plateName;
        this.price = price;
        this.time = time;
        this.descreption = descreption;
    }

    public postDetails(){}
}
