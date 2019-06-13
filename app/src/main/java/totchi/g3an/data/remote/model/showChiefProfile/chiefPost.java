package totchi.g3an.data.remote.model.showChiefProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Medhat on 29/08/2018.
 */

public class chiefPost extends GenralResponse<chiefPost> {

    @SerializedName("id")
    private int id;
    @SerializedName("plateImage")
    private int plateImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlateImage() {
        return plateImage;
    }

    public void setPlateImage(int plateImage) {
        this.plateImage = plateImage;
    }
}
