package totchi.g3an.ui.post_details;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import javax.inject.Inject;
import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;

import butterknife.ButterKnife;
import totchi.g3an.R;
import totchi.g3an.data.remote.model.beforeOrder;
import totchi.g3an.data.remote.model.orderItem;
import totchi.g3an.data.remote.model.showPostDetails.postDetails;
import totchi.g3an.injection.component.ActivityComponent;
import totchi.g3an.ui.base.BaseActivity;
import totchi.g3an.ui.base.BaseView;
import totchi.g3an.ui.basket.foodBasketActivity;
import totchi.g3an.ui.main.HomeActivity;

public class post_details extends BaseActivity implements post_detailsView {

    @BindView(R.id.plate_image)
     ImageView plateImage;
    @BindView(R.id.details_plateName)
    TextView plateName;
    @BindView(R.id.details_platePrice)
     TextView platePrice;
    @BindView(R.id.details_plateTime)
     TextView plateTime;
    @BindView(R.id.details_chiefImage)
     ImageView chiefImage;
    @BindView(R.id.details_chiefName)
     TextView chiefName;
    @BindView(R.id.details_notes)
     TextView notes;
    @BindView(R.id.details_cart)
     Button cart;
    @Inject
    post_detailsPresenter post_detailsPresenter;

    int id;
    postDetails mypost;
    postDetails p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        activityComponent().inject(this);
        post_detailsPresenter.attachView(this);
        ButterKnife.bind(this);

        // remove comment from the 4 below lines
       // Intent intent = getIntent();
       // id  = intent.getIntExtra("postId",0);
       // post_detailsPresenter.getPost(id);
       // presentData(mypost);

     //   if(HomeActivity.index == 1)
     //   {
      //   cart.setVisibility(View.INVISIBLE);
      //  }

       p = new postDetails("khalaf","https://img.freepik.com/free-vector/coloured-chefdesign_1152-72.jpg?size=338&ext=jpg","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","plateName",50,"50","blablabla");
        presentData(p);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void connectionError() {

    }

    @Override
    public void presentData(postDetails post_details) {

        Glide.with(this)
                .load(post_details.getPlateImage())
                .into(plateImage);
        plateName.setText(post_details.getPlateName());
        platePrice.setText((post_details.getPrice()+"جـ "));
        plateTime.setText((post_details.getTime() + "د "));
        Glide.with(this).load(post_details.getChiefImage()).into(chiefImage);
        chiefName.setText(post_details.getChiefName());
        notes.setText(post_details.getDescreption());

    }

    @Override
    public void fillorder(postDetails postDetails) {
        mypost = postDetails;
    }

    public void onclick(View view)
    {
        //  verse vise all function

        orderItem order = new orderItem();

        //order.setChiefName(mypost.getChiefName());
        order.setChiefName(chiefName.getText().toString());

        //order.setChiefImage(mypost.getChiefImage());
        order.setChiefImage("https://img.freepik.com/free-vector/coloured-chefdesign_1152-72.jpg?size=338&ext=jpg");

        beforeOrder b_order = new beforeOrder();

       // b_order.setPlateImage(mypost.getPlateImage());
        b_order.setPlateImage("https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg");

        //b_order.setPlateName(mypost.getPlateName());
        b_order.setPlateName(plateName.getText().toString());

       // b_order.setPlatePrice(String.valueOf(mypost.getPrice()));
        b_order.setPlatePrice(p.getPrice());

        //b_order.setPlateTime(mypost.getTime());
        b_order.setPlateTime(plateTime.getText().toString());

        // by defalut 1 till change within before order activity
        b_order.setQuantity(1);

       // b_order.setId(mypost.getId());
        b_order.setId(1);

        order.setOrder(b_order);

        post_detailsPresenter.addOrder(order);
        Toast.makeText(this," plate orderd success " ,Toast.LENGTH_LONG).show();

    }
}


