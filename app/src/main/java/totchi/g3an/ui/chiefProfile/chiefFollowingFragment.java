package totchi.g3an.ui.chiefProfile;

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
import totchi.g3an.data.remote.model.showChiefs.chiefResponse;
import totchi.g3an.data.remote.model.userLikesAdapter;


public class chiefFollowingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public chiefFollowingFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static chiefFollowingFragment newInstance(String param1, String param2) {
        chiefFollowingFragment fragment = new chiefFollowingFragment();
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
        View v = inflater.inflate(R.layout.fragment_chief_following, container, false);

        RecyclerView rec = v.findViewById(R.id.chief_followingRecyclerView);
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));


        ArrayList<chiefResponse> arr = new ArrayList<chiefResponse>();
        arr.add(new chiefResponse("medhat","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3-puSO7_wxmmuJWei3Y2zVMTL0J6lonhkS5WilJk0fKFA4R6rLQ"));
        arr.add(new chiefResponse("medhat","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3-puSO7_wxmmuJWei3Y2zVMTL0J6lonhkS5WilJk0fKFA4R6rLQ"));
        arr.add(new chiefResponse("medhat","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3-puSO7_wxmmuJWei3Y2zVMTL0J6lonhkS5WilJk0fKFA4R6rLQ"));
        arr.add(new chiefResponse("medhat","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3-puSO7_wxmmuJWei3Y2zVMTL0J6lonhkS5WilJk0fKFA4R6rLQ"));
        arr.add(new chiefResponse("medhat","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3-puSO7_wxmmuJWei3Y2zVMTL0J6lonhkS5WilJk0fKFA4R6rLQ"));

        rec.setAdapter(new userLikesAdapter(arr));
        return v;
    }


}
