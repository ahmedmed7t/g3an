package totchi.g3an.data.remote.model.showChiefs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Medhat on 29/08/2018.
 */

public class chiefResponse extends GenralResponse<chiefResponse> {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("ssn")
    private int ssn;
    @SerializedName("phone")
    private int phone;
    @SerializedName("image")
    private String image;
    @SerializedName("photo")
    private String photo;
    @SerializedName("token")
    private String token;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getSsn() {
        return ssn;
    }

    public int getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public String getPhoto() {
        return photo;
    }

    public String getToken() {
        return token;
    }

    public chiefResponse(String name, String image) {
        this.name = name;
        this.image = image;
    }
    public chiefResponse() {

    }
}
