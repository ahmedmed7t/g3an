package totchi.g3an.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.frgmentOrderRecyclerAdapter;
import totchi.g3an.data.remote.model.orderHint;


public class orderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public orderFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static orderFragment newInstance(String param1, String param2) {
        orderFragment fragment = new orderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_order, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.fragmentOrderRecycler);

        ArrayList<orderHint> order = new ArrayList<orderHint>();
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));

       recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
       recyclerView.setHasFixedSize(true);
       recyclerView.setAdapter(new frgmentOrderRecyclerAdapter(order));

        return v;
    }


}
