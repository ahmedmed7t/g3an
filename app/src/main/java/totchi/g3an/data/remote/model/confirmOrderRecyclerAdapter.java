package totchi.g3an.data.remote.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import totchi.g3an.R;
import totchi.g3an.ui.basket.foodBasketPresenter;

/**
 * Created by Medhat on 20/09/2018.
 */

public class confirmOrderRecyclerAdapter extends RecyclerView.Adapter<confirmOrderRecyclerAdapter.viewHolder> {

    ArrayList<beforeConfirmOrder> arrayList;
    RecyclerView secondry ;

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView chiefName ;
        ImageView chiefImage ;

        public viewHolder(View itemView) {
            super(itemView);

            chiefName = itemView.findViewById(R.id.nested_chiefName);
            chiefImage = itemView.findViewById(R.id.nested_chiefImage);
            secondry = itemView.findViewById(R.id.nested_item_recycler);
        }

    }

    public confirmOrderRecyclerAdapter(ArrayList<beforeConfirmOrder> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_recycler , parent , false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder,  int position) {

        beforeConfirmOrder beforeConfirmOrder = arrayList.get(position);

        holder.chiefName.setText(beforeConfirmOrder.getChiefName());
        Glide.with(holder.itemView.getContext()).load(beforeConfirmOrder.getChiefImage()).into(holder.chiefImage);

        secondry.setHasFixedSize(true);
        secondry.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));

        beforeOrderRecyclerAdapter adt = new beforeOrderRecyclerAdapter(beforeConfirmOrder.getBeforeOrders());
        secondry.setAdapter(adt);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
