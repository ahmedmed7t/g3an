package totchi.g3an.data.remote.model.addPost;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Medhat on 29/08/2018.
 */

public class addPostRequest implements Parcelable {

    @SerializedName("chief_id")
    private int chief_id;
    @SerializedName("plate_id")
    private int plate_id;
    @SerializedName("note")
    private String note;

    public addPostRequest(Parcel in) {
        chief_id = in.readInt();
        plate_id = in.readInt();
        note = in.readString();
    }

    public static final Creator<addPostRequest> CREATOR = new Creator<addPostRequest>() {
        @Override
        public addPostRequest createFromParcel(Parcel in) {
            return new addPostRequest(in);
        }

        @Override
        public addPostRequest[] newArray(int size) {
            return new addPostRequest[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(chief_id);
        dest.writeInt(plate_id);
        dest.writeString(note);
    }
}
