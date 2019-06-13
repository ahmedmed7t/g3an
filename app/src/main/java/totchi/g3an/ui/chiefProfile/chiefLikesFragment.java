package totchi.g3an.ui.chiefProfile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.gridViewAdapter;


public class chiefLikesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public chiefLikesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static chiefLikesFragment newInstance(String param1, String param2) {
        chiefLikesFragment fragment = new chiefLikesFragment();
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
        View v = inflater.inflate(R.layout.fragment_chief_likes, container, false);

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(R.drawable.image);   arr.add(R.drawable.image);
        arr.add(R.drawable.image);   arr.add(R.drawable.image);
        arr.add(R.drawable.image);   arr.add(R.drawable.image);
        arr.add(R.drawable.image);   arr.add(R.drawable.image);

        GridView gridView = v.findViewById(R.id.chief_gridView);
        gridView.setAdapter(new gridViewAdapter(this.getContext(),arr));

        return v;
    }

    
}
