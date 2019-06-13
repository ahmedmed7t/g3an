package totchi.g3an.data.remote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.showAllPosts.post;
import totchi.g3an.ui.main.HomeFragment;
import totchi.g3an.ui.post_details.post_details;

/**
 * Created by Medhat on 01/09/2018.
 */

public class postRecyclerAdapter extends RecyclerView.Adapter<postRecyclerAdapter.viewHolder> {

    private onItemClickListener mlistener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
      mlistener = listener;
    }

    private ArrayList<post> arr;
   // Context context;


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView chief_name;
        ImageView plate_image , chief_photo;
        ConstraintLayout layout;


        public viewHolder(View itemView , final onItemClickListener listener) {
            super(itemView);

            chief_name =  itemView.findViewById(R.id.txt_chiefName);
            plate_image = itemView.findViewById(R.id.plate_image);
            chief_photo = itemView.findViewById(R.id.chief_image);
            layout = itemView.findViewById(R.id.post_cotainer);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }

    public postRecyclerAdapter(ArrayList<post> array ) {
        this.arr = array;
      //  this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);

        return new viewHolder(v , mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {

        post p = arr.get(position);
        holder.chief_name.setText(p.getChiefName().toString());
        Glide.with(holder.itemView.getContext()).load(p.getPlateImage()).into(holder.plate_image);
        Glide.with(holder.itemView.getContext()).load(p.getChiefImage()).into(holder.chief_photo);


    }

    @Override
    public int getItemCount() {
        return arr.size();
    }



}
