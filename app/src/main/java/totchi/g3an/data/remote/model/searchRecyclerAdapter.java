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
import totchi.g3an.data.remote.model.showChiefs.chiefResponse;

/**
 * Created by Medhat on 06/09/2018.
 */

public class searchRecyclerAdapter extends RecyclerView.Adapter<searchRecyclerAdapter.viewHolder> {

    public ArrayList<chiefResponse> array;

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView chiefName;
        ImageView chiefImage;
        public viewHolder(View itemView) {
            super(itemView);
            chiefImage = itemView.findViewById(R.id.searchChiefImage);
            chiefName = itemView.findViewById(R.id.searchChiefName);
        }
    }

    public searchRecyclerAdapter(ArrayList<chiefResponse> arrayList) {
        this.array = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item , parent , false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        chiefResponse chief = array.get(position);

        holder.chiefName.setText(chief.getName());
        Glide.with(holder.itemView.getContext()).load(chief.getImage()).into(holder.chiefImage);
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


}
