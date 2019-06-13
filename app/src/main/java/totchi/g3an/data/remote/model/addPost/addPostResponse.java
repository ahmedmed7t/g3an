package totchi.g3an.data.remote.model.addPost;

import com.google.gson.annotations.SerializedName;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Medhat on 29/08/2018.
 */

public class addPostResponse extends GenralResponse<addPostResponse> {

    @SerializedName("id")
    private int id;
    @SerializedName("note")
    private String note;
    @SerializedName("chiefName")
    private String chiefName;
    @SerializedName("chiefImage")
    private String chiefImage;
    @SerializedName("plateImage")
    private String plateImage;
    @SerializedName("plateName")
    private String plateName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
