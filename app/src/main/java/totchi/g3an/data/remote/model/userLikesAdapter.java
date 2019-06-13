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
 * Created by Medhat on 12/09/2018.
 */

public class userLikesAdapter extends RecyclerView.Adapter<userLikesAdapter.viewholder> {

    public ArrayList<chiefResponse> arrayList;

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView chiefImage ;
        TextView chiefName;
        public viewholder(View itemView) {
            super(itemView);

            chiefImage = itemView.findViewById(R.id.user_likes_ChiefImage);
            chiefName = itemView.findViewById(R.id.user_likes_ChiefName);
        }
    }

    public userLikesAdapter(ArrayList<chiefResponse> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.followingchief_item , parent , false);

        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        chiefResponse chief = arrayList.get(position);

        holder.chiefName.setText(chief.getName());
        Glide.with(holder.itemView.getContext()).load(chief.getImage()).into(holder.chiefImage);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
