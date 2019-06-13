package totchi.g3an.ui.main;

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

import javax.inject.Inject;

import totchi.g3an.R;
import totchi.g3an.data.remote.model.postRecyclerAdapter;
import totchi.g3an.data.remote.model.showAllPosts.post;
import totchi.g3an.ui.base.BaseFragment;
import totchi.g3an.ui.post_details.post_details;


public class HomeFragment extends BaseFragment implements homeFragmentView{
    RecyclerView r ;

    @Inject
    homeFragmentPresenter homeFragmentPresenter;

    ArrayList<post> postArray;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
      //  fragmentComponent().inject(this);

        fragmentComponent().inject(this);
        homeFragmentPresenter.attachView(this);


       View view = inflater.inflate(R.layout.fragment_home, container, false);

        r = (RecyclerView) view.findViewById(R.id.recycler_post);
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(getActivity()));

      // to get data from server  1- remove comment from the 2 below lines
      //  homeFragmentPresenter.fetchPosts();
      // final ArrayList<post> myarray = postArray;

        // 2- remove this array they was a fixed posts to test
        final  ArrayList<post> ar = new ArrayList<post>();
        ar.add(new post("ahmed","https://s3.envato.com/files/229272216/preview.jpg","https://modo3.com/thumbs/fit630x300/28658/1434622053/%D8%B7%D8%B1%D9%8A%D9%82%D8%A9_%D9%88%D8%B1%D9%82_%D8%A7%D9%84%D8%B9%D9%86%D8%A8_%D8%A7%D9%84%D9%84%D8%A8%D9%86%D8%A7%D9%86%D9%8A.jpg"));
        ar.add(new post("medhat","https://s3.envato.com/files/229272216/preview.jpg","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg"));
        ar.add(new post("ahmed medhat ","https://s3.envato.com/files/229272216/preview.jpg","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg"));
        ar.add(new post("ahmed","https://s3.envato.com/files/229272216/preview.jpg","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg"));




        //  3-  put  ( myArray ) insted of ( ar ) in the below adapter
        postRecyclerAdapter adt = new postRecyclerAdapter(ar);
        adt.setOnItemClickListener(new postRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(getContext(),post_details.class);
                // remove the below comment to send the id of selected post to post_details fragment
               // i.putExtra("postId",ar.get(position).getId());
               startActivity(i);
            }
        });


        r.setAdapter(adt);


        return view;
    }



    @Override
    public void fillArray(ArrayList<post> arrayList) {
        postArray = arrayList;
    }


    @Override
    public void connectionError() {

    }
}
