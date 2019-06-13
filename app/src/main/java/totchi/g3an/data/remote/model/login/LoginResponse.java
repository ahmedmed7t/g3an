package totchi.g3an.data.remote.model.login;

import com.google.gson.annotations.SerializedName;

import totchi.g3an.data.remote.model.GenralResponse;

/**
 * Created by Fatma on 06/07/2018.
 */

public class LoginResponse extends GenralResponse<LoginResponse> {
   /* @SerializedName("status")
    boolean stats;
    @SerializedName("data")
    User user;
    @SerializedName("error")
    String error;



    public boolean isStats() {
        return stats;
    }

    public void setStats(boolean stats) {
        this.stats = stats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }*/

   @SerializedName("id")
    private int id;
   @SerializedName("name")
    private String name;
   @SerializedName("email")
    private String email;
   @SerializedName("group_id")
    private int group_id;
   @SerializedName("api_token")
    private String api_token;
   @SerializedName("created_at")
    private String created_at;
   @SerializedName("updated_at")
    private String updated_at;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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

    public int getGroup_id() {
        return group_id;
    }

    public String getApi_token() {
        return api_token;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
