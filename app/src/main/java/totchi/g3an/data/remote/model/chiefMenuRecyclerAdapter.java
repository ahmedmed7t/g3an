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
 * Created by CrazyNet on 03/10/2018.
 */

public class chiefMenuRecyclerAdapter extends RecyclerView.Adapter<chiefMenuRecyclerAdapter.viewholder> {

    public ArrayList<chiefMenu> arrayList ;

    public chiefMenuRecyclerAdapter(ArrayList<chiefMenu> arrayList) {
        this.arrayList = arrayList;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView plateImage;
        TextView plateName , platePrice ;
        public viewholder(View itemView) {
            super(itemView);

            plateImage = itemView.findViewById(R.id.menu_plateImage);
            plateName = itemView.findViewById(R.id.menu_plateName);
            platePrice = itemView.findViewById(R.id.menu_platePrice);
        }
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chief_menu_item , parent , false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        chiefMenu item = arrayList.get(position);
        holder.platePrice.setText(item.getPlatePrice() + "جـ");
        holder.plateName.setText(item.getPlateName());
        Glide.with(holder.itemView.getContext()).load(item.getPlateImage()).into(holder.plateImage);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
