package totchi.g3an.ui.userNotification;

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
import totchi.g3an.data.remote.model.chiefNotificationRecyclerAdapter;
import totchi.g3an.data.remote.model.orderHint;


public class userNotificationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public userNotificationFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static userNotificationFragment newInstance(String param1, String param2) {
        userNotificationFragment fragment = new userNotificationFragment();
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
        View v = inflater.inflate(R.layout.fragment_user_notification, container, false);

        ArrayList<orderHint> arrayList = new ArrayList<orderHint>();
        arrayList.add(new orderHint("Name","https://img.freepik.com/free-vector/coloured-chefdesign_1152-72.jpg?size=338&ext=jpg","17/07/2018"));
        arrayList.add(new orderHint("Name","https://img.freepik.com/free-vector/coloured-chefdesign_1152-72.jpg?size=338&ext=jpg","17/07/2018"));
        arrayList.add(new orderHint("Name","https://img.freepik.com/free-vector/coloured-chefdesign_1152-72.jpg?size=338&ext=jpg","17/07/2018"));
        arrayList.add(new orderHint("Name","https://img.freepik.com/free-vector/coloured-chefdesign_1152-72.jpg?size=338&ext=jpg","17/07/2018"));

        RecyclerView recyclerView = v.findViewById(R.id.user_notification_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new chiefNotificationRecyclerAdapter(arrayList));


        return v;
    }


}
