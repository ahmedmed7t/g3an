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
import android.widget.LinearLayout;

import java.util.ArrayList;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.searchRecyclerAdapter;
import totchi.g3an.data.remote.model.showChiefs.chiefResponse;
import totchi.g3an.ui.base.BaseView;


public class searchFragment extends Fragment implements searchFragmentView {

   public ArrayList<chiefResponse> arrayListOfChiefs;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public searchFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static searchFragment newInstance(String param1, String param2) {
        searchFragment fragment = new searchFragment();
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
       View v = inflater.inflate(R.layout.fragment_search, container, false);

       RecyclerView recyclerView = v.findViewById(R.id.recycler_search);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       recyclerView.setHasFixedSize(true);

       ArrayList<chiefResponse> arr = new ArrayList<chiefResponse>();
       arr.add(new chiefResponse("medhat","https://s3.envato.com/files/229272216/preview.jpg"));
        arr.add(new chiefResponse("medhat","https://s3.envato.com/files/229272216/preview.jpg"));
        arr.add(new chiefResponse("medhat","https://s3.envato.com/files/229272216/preview.jpg"));

       recyclerView.setAdapter(new searchRecyclerAdapter(arr));
        return v;
    }



    @Override
    public void connectionError() {

    }

    @Override
    public void sendArrayToView(ArrayList<chiefResponse> arrayList) {
        arrayListOfChiefs = arrayList;
    }


}
