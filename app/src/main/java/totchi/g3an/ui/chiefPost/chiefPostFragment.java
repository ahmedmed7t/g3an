package totchi.g3an.ui.chiefPost;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.gridViewAdapter;
import totchi.g3an.ui.base.BaseFragment;


public class chiefPostFragment extends BaseFragment implements chiefPostView {

    ArrayList<Integer> arrayList_images;
    @Inject
    chiefPostPresenter presenter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public chiefPostFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static chiefPostFragment newInstance(String param1, String param2) {
        chiefPostFragment fragment = new chiefPostFragment();
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
        View view = inflater.inflate(R.layout.fragment_chief_post, container, false);


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);
        arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);   arrayList.add(R.drawable.food);


        // to get data from server
       // presenter.getPosts();

        GridView grid = view.findViewById(R.id.Grid_chiefPost);
                                                  // put here arrayList_images
        grid.setAdapter(new gridViewAdapter(view.getContext(),arrayList));


        return view;
    }


    @Override
    public void getImages(ArrayList<Integer> arrayList) {
       arrayList_images = arrayList;
    }

    @Override
    public void connectionError() {
    }
}
