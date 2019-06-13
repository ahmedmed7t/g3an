package totchi.g3an.ui.chief_notification;

import android.content.Context;
import android.content.Intent;
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
import totchi.g3an.data.remote.model.chiefNotificationRecyclerAdapter;
import totchi.g3an.data.remote.model.frgmentOrderRecyclerAdapter;
import totchi.g3an.data.remote.model.orderHint;
import totchi.g3an.ui.chiefNotificationDetails.NotificationDetailsActivity;


public class chiefNotificationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public chiefNotificationFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static chiefNotificationFragment newInstance(String param1, String param2) {
        chiefNotificationFragment fragment = new chiefNotificationFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chief_notification, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.chief_notification
        );

        ArrayList<orderHint> order = new ArrayList<orderHint>();
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));
        order.add(new orderHint("name","https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg","17/7/2018"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        chiefNotificationRecyclerAdapter adt = new chiefNotificationRecyclerAdapter(order);
        adt.setOnItemClickListener(new chiefNotificationRecyclerAdapter.onItemClickListener() {
            @Override
            public void onClick(int position) {
                getActivity().startActivity(new Intent(getContext(), NotificationDetailsActivity.class));
            }
        });
        recyclerView.setAdapter(adt);

        return v;
    }


}
