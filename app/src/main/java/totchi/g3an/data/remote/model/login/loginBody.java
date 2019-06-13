package totchi.g3an.data.remote.model.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medhat on 28/08/2018.
 */

public class loginBody implements Parcelable {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public loginBody(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    public loginBody() {

    }

    public static final Creator<loginBody> CREATOR = new Creator<loginBody>() {
        @Override
        public loginBody createFromParcel(Parcel in) {
            return new loginBody(in);
        }

        @Override
        public loginBody[] newArray(int size) {
            return new loginBody[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
    }
}
