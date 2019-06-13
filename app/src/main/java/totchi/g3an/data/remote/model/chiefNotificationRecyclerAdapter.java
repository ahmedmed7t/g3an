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
 * Created by CrazyNet on 04/10/2018.
 */

public class chiefNotificationRecyclerAdapter extends RecyclerView.Adapter<chiefNotificationRecyclerAdapter.viewholder> {

    ArrayList<orderHint> arrayList;

    public void setArrayList(ArrayList<orderHint> arrayList) {
        this.arrayList = arrayList;
    }
    public onItemClickListener onItemClickListener;
    public interface onItemClickListener{
        void onClick(int position);
    }

    public chiefNotificationRecyclerAdapter(ArrayList<orderHint> arrayList) {
        this.arrayList = arrayList;
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {

        this.onItemClickListener = onItemClickListener;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView order , date;
        ImageView plateImage;
        public viewholder(View itemView , final onItemClickListener listener) {
            super(itemView);

            order = itemView.findViewById(R.id.fragment_orderPlates);
            date = itemView.findViewById(R.id.fragment_orderDate);
            plateImage = itemView.findViewById(R.id.fragment_orderPlateImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onClick(position);
                        }
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_order_item,parent,false);

        return new viewholder(v,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        orderHint item = arrayList.get(position);

        holder.order.setText(item.getPlateName());
        holder.date.setText(item.getDate());
        Glide.with(holder.itemView.getContext()).load(item.getPlateImage()).into(holder.plateImage);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
