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
import java.util.zip.Inflater;

import totchi.g3an.R;

/**
 * Created by Medhat on 20/09/2018.
 */

public class frgmentOrderRecyclerAdapter extends RecyclerView.Adapter<frgmentOrderRecyclerAdapter.viewHolder> {

    ArrayList<orderHint> arrayList ;

    public frgmentOrderRecyclerAdapter(ArrayList<orderHint> arrayList) {
        this.arrayList = arrayList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView order , date ;
        ImageView plateImage ;
        public viewHolder(View itemView) {
            super(itemView);

            order = itemView.findViewById(R.id.fragment_orderPlates);
            date = itemView.findViewById(R.id.fragment_orderDate);
            plateImage = itemView.findViewById(R.id.fragment_orderPlateImage);
        }
    }

    @NonNull
    @Override
    public frgmentOrderRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_order_item , parent , false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull frgmentOrderRecyclerAdapter.viewHolder holder, int position) {

        orderHint orderHint = arrayList.get(position);

        holder.order.setText(orderHint.getPlateName());
        holder.date.setText(orderHint.getDate());
        Glide.with(holder.itemView.getContext()).load(orderHint.getPlateImage()).into(holder.plateImage);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
