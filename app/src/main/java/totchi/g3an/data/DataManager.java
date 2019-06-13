package totchi.g3an.data;


import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;
import totchi.g3an.data.local.SharedPrefencesHelper;
import totchi.g3an.data.remote.G3anService;
import totchi.g3an.data.remote.model.GenralResponse;
import totchi.g3an.data.remote.model.login.LoginResponse;
import totchi.g3an.data.remote.model.signUp.SignupBody;
import totchi.g3an.data.remote.model.signUp.User;
import totchi.g3an.data.remote.model.addNewOrder.addOrderRequest;
import totchi.g3an.data.remote.model.addNewOrder.addOrderResponse;
import totchi.g3an.data.remote.model.addPost.addPostRequest;
import totchi.g3an.data.remote.model.addPost.addPostResponse;
import totchi.g3an.data.remote.model.showChiefProfile.chiefPost;
import totchi.g3an.data.remote.model.showChiefs.chiefResponse;
import totchi.g3an.data.remote.model.login.loginBody;
import totchi.g3an.data.remote.model.showAllPosts.post;
import totchi.g3an.data.remote.model.showPostDetails.postDetails;
import totchi.g3an.data.remote.model.showOrders.showOrdersResponse;
import totchi.g3an.data.remote.model.showPlates.showPlatesInOneResponse;

/**
 * Created by Fatma on 03/07/2018.
 */

public class DataManager {
    SharedPrefencesHelper sharedPrefencesHelper;
    G3anService g3anService;

    @Inject
    public DataManager(SharedPrefencesHelper sharedPrefencesHelper, G3anService g3anService) {
        this.sharedPrefencesHelper = sharedPrefencesHelper;
        this.g3anService = g3anService;
    }

    public Single<User> register(SignupBody body) {
        return g3anService.signup(body);
    }

    public Single<GenralResponse<ArrayList<chiefResponse>>> showchief() { return g3anService.showChiefs(); }

    public Single<LoginResponse> login(loginBody body){ return g3anService.login(body); }

    public Single<GenralResponse<ArrayList<chiefPost>>> showChiefProfile(int id) {return g3anService.showProfile(id); }

    public Single<GenralResponse<ArrayList<post>>> showAllPosts(){ return g3anService.showPosts(); }

    public Single<GenralResponse<postDetails>> showPostDetails(int id) {return g3anService.showPostDetails(id);}

    public Single<addPostResponse> addNewPost(addPostRequest addPostRequest){return g3anService.addnewpost(addPostRequest);}

    public Single<showPlatesInOneResponse> showAllInOneCategory(int id){return g3anService.showAllInOneCategory(id);}

    public Single<showPlatesInOneResponse> showAllCategories(){return g3anService.showAllCategories();}

    public Single<addOrderResponse> addOrder(addOrderRequest addOrderRequest){return g3anService.addOrder(addOrderRequest);}

    public Single<showOrdersResponse> showAllOrders(){return g3anService.showOrders();}

    public void saveUserdata(User user) {
        sharedPrefencesHelper.put("user", user);
    }

    public Single<User> getUser() {
        return sharedPrefencesHelper.getObject("user", User.class);
    }

}
