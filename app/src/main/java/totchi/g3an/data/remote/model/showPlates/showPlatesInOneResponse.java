package totchi.g3an.data.remote.model.showPlates;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Medhat on 29/08/2018.
 */

public class showPlatesInOneResponse extends GenralResponse<List<showPlatesInOneResponse>> {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
