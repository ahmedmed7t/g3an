package totchi.g3an.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import totchi.g3an.R;
import totchi.g3an.ui.addPlate.addPlateActivity;
import totchi.g3an.ui.chiefMenu.chiefMenuFragment;
import totchi.g3an.ui.chiefPost.chiefPostFragment;
import totchi.g3an.ui.chiefProfile.chiefProfileFragment;
import totchi.g3an.ui.chief_notification.chiefNotificationFragment;
import totchi.g3an.ui.userNotification.userNotificationFragment;
import totchi.g3an.ui.userProfile.userProfileFragment;
import totchi.g3an.ui.basket.foodBasketActivity;

public class HomeActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private TextView mTextMessage;

    public String in ;
    public int index ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
 //               case R.id.navigation_home:
 //               mTextMessage.setText(R.string.title_home);
 //                   return true;
 //               case R.id.navigation_dashboard:
//                  mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        index = getIntent().getIntExtra("i",0);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        BottomNavigationView chiefNav = findViewById(R.id.chief_navigation);


        if(index == 0 ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HomeFragment()).commit();


            bottomNavigationView.setVisibility(View.VISIBLE);
            chiefNav.setVisibility(View.INVISIBLE);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    int id = item.getItemId();


                    switch (id) {
                        case R.id.navigation_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.navigation_search:
                            fragment = new searchFragment();
                            break;

                        case R.id.navigation_profile:
                            fragment = new userProfileFragment();
                            break;

                        case R.id.navigation_dashboard:
                            fragment = new orderFragment();
                            break;

                        case R.id.navigation_notifications:
                            fragment = new userNotificationFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
                    return false;
                }
            });
        }
        if(index == 1) {

            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HomeFragment()).commit();

            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.side_menu_chief);

            bottomNavigationView.setVisibility(View.INVISIBLE);
            chiefNav.setVisibility(View.VISIBLE);
            chiefNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    int id = item.getItemId();

                    switch (id) {
                        case R.id.navigation_chiefHome:
                            fragment = new HomeFragment();
                            break;

                        case R.id.navigation_chiefSearch:
                            fragment = new searchFragment();
                            break;

                        case R.id.navigation_chiefProfile:
                            fragment = new chiefProfileFragment();
                            break;

                        case R.id.navigation_chiefPosts:
                            fragment = new chiefPostFragment();
                            break;
                        case R.id.navigation_chiefNotifications:
                            fragment = new chiefNotificationFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
                    return false;
                }
            });


        }

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_order) {
            // Handle the camera action
            Intent i = new Intent( this , foodBasketActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_addPost)
        {
            Intent i = new Intent( this , addPlateActivity.class);
            startActivity(i);
        }
        else if (id == R.id.nav_menu)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new chiefMenuFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
