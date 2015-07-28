package com.furballwear.apps.pugrz.activities;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.furballwear.apps.pugrz.App;
import com.furballwear.apps.pugrz.R;
import com.furballwear.apps.pugrz.basicsyncadapter.EntryListFragment;
import com.furballwear.apps.pugrz.basicsyncadapter.SyncUtils;
import com.furballwear.apps.pugrz.common.Utils;
import com.furballwear.apps.pugrz.fragments.AttractionListFragment;
import com.furballwear.apps.pugrz.fragments.BoardGameFragment;
import com.furballwear.apps.pugrz.fragments.FragmentBoxOffice;
import com.furballwear.apps.pugrz.fragments.MyFragment;
import com.furballwear.apps.pugrz.message.TopicListActivity;
import com.furballwear.apps.pugrz.service.UtilityService;

import com.furballwear.apps.pugrz.ui.RemoteFileDemo;
import com.furballwear.apps.pugrz.fragments.Welcomefragment;
import com.furballwear.apps.pugrz.utils.IAppConstants;
import com.furballwear.apps.pugrz.utils.PrefUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Welcomefragment.OnFragmentInteractionListener {

    private static final long POLL_FREQUENCY = 28800000;
    private JobScheduler mJobScheduler;
    private static final int JOB_ID = 100;
    private DrawerLayout mDrawerLayout;
    public static final int WELCOME_FRAGMENT =0;
    public static final int CARDS_FRAGMENT =2;
    public static final int BOARDS_FRAGMENT =1;
    public static final int TABLETOP_FRAGMENT =4;
    public static final int ATTRACTION_FRAGMENT =3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtilityService.addGeofences(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView = (ImageView)findViewById(R.id.mybackdrop);
        Glide.with(this).load(BaseActivity.getRandomCheeseDrawable()).into(imageView);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EventPost.class));
            }
        });

        PagerTitleStrip tabLayout = (PagerTitleStrip) findViewById(R.id.tabs);
        tabLayout.setEnabled(true);


    }





    @Override
    protected void onResume() {
        super.onResume();
        UtilityService.requestLocation(this);
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                SyncUtils.TriggerRefresh();
                return true;
            case R.id.test_notification:
                UtilityService.triggerWearTest(this, false);
                showDebugDialog(R.string.action_test_notification,
                        R.string.action_test_notification_dialog);
                return true;
            case R.id.test_microapp:
                UtilityService.triggerWearTest(this, true);
                showDebugDialog(R.string.action_test_microapp,
                        R.string.action_test_microapp_dialog);
                return true;
            case R.id.test_toggle_geofence:
                boolean geofenceEnabled = Utils.getGeofenceEnabled(this);
                Utils.storeGeofenceEnabled(this, !geofenceEnabled);
                Toast.makeText(this, geofenceEnabled ?
                        "Debug: Geofencing trigger disabled" :
                        "Debug: Geofencing trigger enabled", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }*/

    private void showDebugDialog(int titleResId, int bodyResId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(titleResId)
                .setMessage(bodyResId)
                .setPositiveButton(android.R.string.ok, null);
        builder.create().show();
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new Welcomefragment(), "Welcome");
        adapter.addFragment(new BoardGameFragment(),"Board games");
        adapter.addFragment(new FragmentBoxOffice(),"box games");
        adapter.addFragment(new EntryListFragment(),"entry games");
                viewPager.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        TextView usernameview;
      usernameview = (TextView)navigationView.findViewById(R.id.username);
        usernameview.setText(PrefUtil.getString(getApplicationContext(), IAppConstants.DISPLAY_NAME));
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        if (menuItem.getItemId() == R.id.my_events) {
                            startActivity(new Intent(MainActivity.this, FriendsList.class));
                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                        if (menuItem.getItemId() == R.id.nav_friends) {
                            startActivity(new Intent(MainActivity.this, FreindsActivity.class));

                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                        if (menuItem.getItemId() == R.id.nav_Settings) {
                            startActivity(new Intent(MainActivity.this, RemoteFileDemo.class));

                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                        if (menuItem.getItemId() == R.id.nav_discussion) {
                            startActivity(new Intent(MainActivity.this, TopicListActivity.class));

                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                        if (menuItem.getItemId() == R.id.nav_logout) {
                            logout();
                            mDrawerLayout.closeDrawers();
                            return true;
                        }

                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }

                });
    }
    protected void logout() {
        PrefUtil.putString(getApplicationContext(), IAppConstants.SESSION_ID, "");
        PrefUtil.putString(getApplicationContext(), IAppConstants.EMAIL, "");
        PrefUtil.putString(getApplicationContext(), IAppConstants.PWD, "");
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);

        }
      /*  @Override
        public Fragment getItem(int num) {
            Fragment fragment = null;
//            L.m("getItem called for " + num);
            switch (num) {
                case WELCOME_FRAGMENT:
                    fragment = Welcomefragment.newInstance("", "");
                    break;
                case BOARDS_FRAGMENT:
                    fragment = BoardGameFragment.newInstance("","");
                    break;
                case CARDS_FRAGMENT:

                    fragment = FragmentBoxOffice.newInstance("","");
                    break;
                case ATTRACTION_FRAGMENT:

                    fragment = AttractionListFragment.newInstance();
                    break;
            }
            return fragment;

        }*/

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }


   /* private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        int icons[] = {R.drawable.ic_action_home,
                R.drawable.ic_pugrz,
                R.drawable.ic_action_users};

        FragmentManager fragmentManager;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentManager = fm;
        }

        public Fragment getItem(int num) {
            Fragment fragment = null;
//            L.m("getItem called for " + num);
            switch (num) {
                case TABLETOP_FRAGMENT:
                    fragment = Welcomefragment.newInstance("", "");
                    break;
                case BOARDS_FRAGMENT:
                    fragment = AttractionListFragment.newInstance();
                    break;
                case CARDS_FRAGMENT:
                 //   fragment = MyFragment.newInstance("", "");
                    fragment = AttractionListFragment.newInstance();
                    break;
                case ATTRACTION_FRAGMENT:
                    //   fragment = MyFragment.newInstance("", "");
                    fragment = AttractionListFragment.newInstance();
                    break;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getStringArray(R.array.gametype)[position];
        }

        private Drawable getIcon(int position) {
            return getResources().getDrawable(icons[position]);
        }
    }*/
}
