package totchi.g3an.data.remote.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import totchi.g3an.R;

/**
 * Created by Medhat on 04/10/2018.
 */

public class chiefNotificationDetailsAdapter extends RecyclerView.Adapter<chiefNotificationDetailsAdapter.viewholder> {

    ArrayList<beforeOrder> arrayList;

    public chiefNotificationDetailsAdapter(ArrayList<beforeOrder> arrayList) {
        this.arrayList = arrayList;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView plateImage;
        TextView plateName , platePrice , plateTime , quantity ;

        public viewholder(View itemView) {
            super(itemView);

            plateImage = itemView.findViewById(R.id.DN_plate_image);
            plateName = itemView.findViewById(R.id.DN_plate_name);
            platePrice = itemView.findViewById(R.id.DN_plate_price);
            plateTime = itemView.findViewById(R.id.DN_plate_time);
            quantity = itemView.findViewById(R.id.DN_quantity);
        }
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chief_details_notif_item,parent,false);

        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        beforeOrder item = arrayList.get(position);

        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.plateTime.setText(item.getPlateTime()+" د ");
        holder.platePrice.setText(String.valueOf(item.getPlatePrice())+" جـ ");
        holder.plateName.setText(item.getPlateName());
        Glide.with(holder.itemView.getContext()).load(item.getPlateImage()).into(holder.plateImage);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
