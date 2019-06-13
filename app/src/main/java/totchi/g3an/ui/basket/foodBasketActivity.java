package totchi.g3an.ui.basket;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import totchi.g3an.R;
import totchi.g3an.data.remote.model.beforeOrder;
import totchi.g3an.data.remote.model.confirmOrderRecyclerAdapter;
import totchi.g3an.data.remote.model.orderItem;
import totchi.g3an.ui.base.BaseActivity;
import totchi.g3an.data.remote.model.beforeConfirmOrder;


public class foodBasketActivity extends BaseActivity implements foodBasketView {

    public static ArrayList<beforeConfirmOrder> items = new ArrayList<beforeConfirmOrder>();

   public static foodBasketPresenter presenter ;

    public static TextView total;
    public EditText street ;
    public EditText building ;
    public EditText region ;
    public EditText specialMark ;
    public String addres;
    public static float totalPrice;
    public static int userID ;
    public static int index =0;
    public static RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_basket);

        presenter = new foodBasketPresenter();
        total = findViewById(R.id.total);
        street = findViewById(R.id.street);
        building = findViewById(R.id.build);
        region = findViewById(R.id.region);
        specialMark = findViewById(R.id.edit_specialMark);


        presenter.attachView(this);
        presenter.checkMultiChief();

        if(index == 0) {
            ArrayList<beforeOrder> arr = new ArrayList<beforeOrder>();
            arr.add(new beforeOrder("https://amp.businessinsider.com/images/5a7dc169d03072af008b4bf2-750-562.jpg", "name", 150, "50", 1));

            ArrayList<beforeOrder> arr1 = new ArrayList<beforeOrder>();
            arr1.add(new beforeOrder("https://amp.businessinsider.com/images/5a7dc169d03072af008b4bf2-750-562.jpg", "name", 150, "50", 1));

            ArrayList<beforeOrder> arr2 = new ArrayList<beforeOrder>();
            arr2.add(new beforeOrder("https://amp.businessinsider.com/images/5a7dc169d03072af008b4bf2-750-562.jpg", "name", 150, "50", 1));


            items.add(new beforeConfirmOrder("https://us.123rf.com/450wm/stocking/stocking1604/stocking160401621/55653858-smiling-chef-in-his-kitchen.jpg?ver=6", "medhat", arr));
            items.add(new beforeConfirmOrder("https://us.123rf.com/450wm/stocking/stocking1604/stocking160401621/55653858-smiling-chef-in-his-kitchen.jpg?ver=6", "ahmed", arr1));
            items.add(new beforeConfirmOrder("https://us.123rf.com/450wm/stocking/stocking1604/stocking160401621/55653858-smiling-chef-in-his-kitchen.jpg?ver=6", "mohamed", arr2));

            orderItem i = new orderItem("https://us.123rf.com/450wm/stocking/stocking1604/stocking160401621/55653858-smiling-chef-in-his-kitchen.jpg?ver=6", "medhat", new beforeOrder("https://amp.businessinsider.com/images/5a7dc169d03072af008b4bf2-750-562.jpg", "mmmmmm", 50, "50", 1));
            orderItem e = new orderItem("https://us.123rf.com/450wm/stocking/stocking1604/stocking160401621/55653858-smiling-chef-in-his-kitchen.jpg?ver=6", "ahmed", new beforeOrder("https://amp.businessinsider.com/images/5a7dc169d03072af008b4bf2-750-562.jpg", "aaaaa", 50, "50", 1));
            orderItem h = new orderItem("https://us.123rf.com/450wm/stocking/stocking1604/stocking160401621/55653858-smiling-chef-in-his-kitchen.jpg?ver=6", "moham", new beforeOrder("https://amp.businessinsider.com/images/5a7dc169d03072af008b4bf2-750-562.jpg", "hhhhh", 50, "50", 1));

            presenter.addToArray(items, i);
            presenter.addToArray(items, e);
            presenter.addToArray(items, h);
          index++;
        }

        foodBasketPresenter.calcTotal();

        recyclerView = findViewById(R.id.orderRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new confirmOrderRecyclerAdapter(items));

      presentTotal();
    }




    public static void presentTotal() {
        total.setText(String.valueOf(totalPrice +"جـ"));
    }


    public static void displayarray() {
       recyclerView.setAdapter(new confirmOrderRecyclerAdapter(items));
    }

    public void onClick(View view)
    {
        if(region.getText().toString() != "" && street.getText().toString() != "" && building.getText().toString() != "" && specialMark.getText().toString() != "" ) {
            addres = region.getText().toString() + "_" + street.getText().toString() + "_" + building.getText().toString() + "_" + specialMark.getText().toString();
        }

       // presenter.addOrders(addres);
        Toast.makeText(this," order success " , Toast.LENGTH_LONG).show();
        items.clear();

    }

    @Override
    public void showDialog() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("تنوية");
        builder1.setMessage(" لكل طباخ سعر توصيل خاص به ");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void connectionError() {

    }
}
