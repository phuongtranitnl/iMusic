package android2.team2.imusic.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import android2.team2.imusic.R;
import android2.team2.imusic.adapters.TabPagerAdapter;
import android2.team2.imusic.fragments.EmptyPageFragment;
import android2.team2.imusic.fragments.PageFragment;
import android2.team2.imusic.fragments.SongFragment;
import android2.team2.imusic.models.Empty;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private EmptyPageFragment emptyPageFragment;
    private LinearLayout bottomPlayingBar;

    private static boolean statusTabEmpty = true;
    private List<Empty> emptyList;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.drawerLayout = findViewById(R.id.drawerMainLayout);
        this.navigationView = findViewById(R.id.navMainView);
        this.appBarLayout = findViewById(R.id.appBar);
        this.toolbar = findViewById(R.id.toolBar);
        this.tabLayout = findViewById(R.id.tabBar);
        this.viewPager = findViewById(R.id.viewPager);
        this.bottomPlayingBar = findViewById(R.id.bottom_playing_bar);

        emptyFragment();
        initDrawerNavigation();
        initToolbar();
        initViewPager(viewPager);
        this.tabLayout.setupWithViewPager(this.viewPager);
        initIconTab();

        bottomPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayingActivity.class));
            }
        });
    }

    //    Setup Empty
    private void emptyFragment() {
        this.emptyList = new ArrayList<>();
        this.emptyList.add(new Empty(R.drawable.img_no_chat, "No songs", "Add song"));
        this.emptyList.add(new Empty(R.drawable.img_no_feed, "No artists", "Add artist"));
        this.emptyList.add(new Empty(R.drawable.img_no_friend, "No albums", "Add album"));
        this.emptyList.add(new Empty(R.drawable.img_no_internet_satellite, "No favorites", "Add favorite"));
    }

    //    Setup Drawer Navigation
    private void initDrawerNavigation() {


        this.navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        this.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    //    Setup Toolbar
    private void initToolbar() {
        this.toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Setup View Pager
    private void initViewPager(ViewPager viewPager) {
        this.tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        this.tabPagerAdapter.addFragment(new SongFragment(), "Songs");
        this.tabPagerAdapter.addFragment(new PageFragment(), "Albums");
        this.tabPagerAdapter.addFragment(new PageFragment(), "Artists");
        this.tabPagerAdapter.addFragment(new PageFragment(), "Favorites");
        viewPager.setAdapter(this.tabPagerAdapter);
    }

    //Setup Icon Tab
    private void initIconTab() {
        //Add icon tab
        this.tabLayout.getTabAt(0).setIcon(R.drawable.ic_song);
        this.tabLayout.getTabAt(1).setIcon(R.drawable.ic_folder);
        this.tabLayout.getTabAt(2).setIcon(R.drawable.ic_user);
        this.tabLayout.getTabAt(3).setIcon(R.drawable.ic_heart);

        //Set color icon tab
        this.tabLayout.getTabAt(0).getIcon().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        this.tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        this.tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        this.tabLayout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);

        getSupportActionBar().setTitle("Songs");
        changeColorIconTab();
    }

    //Change color icon tab
    private void changeColorIconTab() {
        this.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Change toolbar title
                getSupportActionBar().setTitle(tabPagerAdapter.getTitle(tab.getPosition()));
                //Change color icon tab
                tab.getIcon().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_search:
                showDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //func set dialog
    private void showDialog() {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_search);
//        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }



}
