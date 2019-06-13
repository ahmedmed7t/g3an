package totchi.g3an.data.remote.model.signUp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fatma on 06/07/2018.
 */

public class SignupBody implements Parcelable {
    @SerializedName("name")
    private String firstName;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("password_confirmation")
    private String confirmPass;
    @SerializedName("photo")
    private String photo;
    @SerializedName("image")
    private String image;
    @SerializedName("SSN")
    private String sid;
    @SerializedName("phone")
    private String phone;
    @SerializedName("type")
    private String type;
    @SerializedName("MAC")
    private String MACaddress;

    public SignupBody(Parcel in) {
        firstName = in.readString();
        email = in.readString();
        password = in.readString();
        confirmPass = in.readString();
        photo = in.readString();
        image = in.readString();
        sid = in.readString();
        phone = in.readString();
        type = in.readString();
        MACaddress = in.readString();
    }

    public SignupBody() {

    }

    public static final Creator<SignupBody> CREATOR = new Creator<SignupBody>() {
        @Override
        public SignupBody createFromParcel(Parcel in) {
            return new SignupBody(in);
        }

        @Override
        public SignupBody[] newArray(int size) {
            return new SignupBody[size];
        }
    };

    public String getMACaddress() {
        return MACaddress;
    }

    public void setMACaddress(String MACaddress) {
        this.MACaddress = MACaddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(confirmPass);
        parcel.writeString(photo);
        parcel.writeString(image);
        parcel.writeString(sid);
        parcel.writeString(phone);
        parcel.writeString(type);
        parcel.writeString(MACaddress);
    }
}
