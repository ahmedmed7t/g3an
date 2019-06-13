package totchi.g3an.ui.chiefNotificationDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.beforeOrder;
import totchi.g3an.data.remote.model.chiefNotificationDetailsAdapter;

public class NotificationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_details);

        ArrayList<beforeOrder> arr = new ArrayList<beforeOrder>();
        arr.add(new beforeOrder("https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","name",150,"50",2));
        arr.add(new beforeOrder("https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","name",150,"50",2));
        arr.add(new beforeOrder("https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","name",150,"50",2));
        arr.add(new beforeOrder("https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","name",150,"50",2));

        RecyclerView recyclerView = findViewById(R.id.DN_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new chiefNotificationDetailsAdapter(arr));
    }
}
