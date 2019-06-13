package totchi.g3an.data.remote.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import totchi.g3an.R;
import totchi.g3an.ui.basket.foodBasketActivity;
import totchi.g3an.ui.basket.foodBasketPresenter;

/**
 * Created by Medhat on 26/09/2018.
 */

public class beforeOrderRecyclerAdapter extends RecyclerView.Adapter<beforeOrderRecyclerAdapter.viewHolder> {

    private ArrayList<beforeOrder> arrayList;
    public int quant ;
    public beforeOrderRecyclerAdapter(ArrayList<beforeOrder> arrayList ) {
        this.arrayList = arrayList;

    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView plateName , platePrice , plateTime , quantity;
        ImageView plateImage;
        Button plus , minus , delete;

        public viewHolder(View itemView) {
            super(itemView);

            plateName = itemView.findViewById(R.id.nested_plate_name);
            plateImage = itemView.findViewById(R.id.nested_plate_image);
            platePrice = itemView.findViewById(R.id.nested_plate_price);
            plateTime = itemView.findViewById(R.id.nested_plate_time);
            quantity = itemView.findViewById(R.id.nested_quantity);
            plus = itemView.findViewById(R.id.nested_plus);
            minus = itemView.findViewById(R.id.nested_minus);
            delete = itemView.findViewById(R.id.nested_x);

            plus.setOnClickListener(this);
            minus.setOnClickListener(this);
            delete.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == plus.getId())
            {
               quant = Integer.parseInt(quantity.getText().toString())+ 1 ;

                quantity.setText(String.valueOf(quant));
                arrayList.get(getAdapterPosition()).setQuantity(quant);
                foodBasketPresenter.calcTotal();
                foodBasketActivity.presentTotal();

            }else if (v.getId() == minus.getId() && Integer.parseInt(quantity.getText().toString()) > 1)
            {
                quant = Integer.parseInt(quantity.getText().toString()) - 1 ;

                quantity.setText(String.valueOf(quant));
                arrayList.get(getAdapterPosition()).setQuantity(quant);
                foodBasketPresenter.calcTotal();
               foodBasketActivity.presentTotal();
            }
            else if(v.getId() == delete.getId())
            {
                arrayList.get(getAdapterPosition()).setDelete(true);
                foodBasketPresenter.filterArray();
            }
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item , parent , false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        beforeOrder item = arrayList.get(position);

        arrayList.get(position).setQuantity(1);
        holder.plateName.setText(item.getPlateName());
        holder.plateTime.setText(item.getPlateTime()+"د");
        holder.platePrice.setText(item.getPlatePrice()+"جـ");
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        Glide.with(holder.itemView.getContext()).load(item.getPlateImage()).into(holder.plateImage);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
