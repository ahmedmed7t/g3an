package totchi.g3an.data.remote;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import totchi.g3an.data.remote.model.GenralResponse;
import totchi.g3an.data.remote.model.addPlate.addPlateRequest;
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
 * Created by Fatma on 04/07/2018.
 */

public interface G3anService {
    String BASE_URL = "http://52.47.210.29";
    String LINK = "api/v1/";
    String Authorization = "Authorization";

    // register as a user or chief
    @POST(LINK + "users/add")
    Single<User> signup(@Body SignupBody body);

    // login as a user or chief
    @POST(LINK + "users/login")
    Single<LoginResponse> login(@Body loginBody body);

    // show all chief
    @GET(LINK + "chief")
    Single<GenralResponse<ArrayList<chiefResponse>>> showChiefs();

    // show chief profile
    @GET( LINK + "profile/{id}")
    Single<GenralResponse<ArrayList<chiefPost>>> showProfile (@Path("id") int id);

    // show all posts
    @GET(LINK + "post")
    Single<GenralResponse<ArrayList<post>>> showPosts();

    // show post details
    @GET(LINK + "post/getById/{id}")
    Single<GenralResponse<postDetails>> showPostDetails (@Path("id") int id);

    // add new post
    @POST (LINK + "post/add")
    Single <addPostResponse> addnewpost(addPostRequest addPostRequest);

    // show all plates in one category
    @GET(LINK + "categoriee/show/{id}")
    Single<showPlatesInOneResponse> showAllInOneCategory(@Path("id") int id);

    // show all categories
    @GET(LINK + "categorie")
    Single<showPlatesInOneResponse> showAllCategories();

    //dd new order
    @POST(LINK + "order/add")
    Single<addOrderResponse> addOrder (addOrderRequest addOrderRequest);

    // show all orders
    @GET(LINK + "order")
    Single<showOrdersResponse> showOrders();

    class Creator {
        public static G3anService newIHelpService() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).build();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
            return retrofit.create(G3anService.class);
        }
    }
}
