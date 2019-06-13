package totchi.g3an.ui.chiefProfile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import totchi.g3an.R;
import totchi.g3an.ui.userProfile.userFollowingFragment;
import totchi.g3an.ui.userProfile.userLikeFragment;


public class chiefProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public chiefProfileFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static chiefProfileFragment newInstance(String param1, String param2) {
        chiefProfileFragment fragment = new chiefProfileFragment();
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
        View v = inflater.inflate(R.layout.fragment_chief_profile, container, false);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chief_likesFollowingContainer,new chiefLikesFragment()).commit();

        BottomNavigationView bottomNavigationView = v.findViewById(R.id.user_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id){
                    case R.id.chief_navigation_likes :
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chief_likesFollowingContainer,new chiefLikesFragment() ).commit();
                        break;
                    case R.id.chief_navigation_following :
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chief_likesFollowingContainer,new chiefFollowingFragment() ).commit();
                        break;
                    case R.id.chief_navigation_followers :
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chief_likesFollowingContainer,new chiefFollowerFragment() ).commit();
                        break;
                }

                return false;
            }
        });

        return v;
    }

   
}
