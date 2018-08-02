package com.ritikaneema.indorevisita;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static int mutedColor;

    TabLayout tabLayout;
    ViewPager viewPager;
    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout navDrawer;
    LinearLayout navHeader;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupNavigationView();

        setUpTabs();

        try {
            Bundle bundle = getIntent().getExtras();
            int fragment = Integer.valueOf(bundle.getString("FRAGMENT"));
            setRequestedFragment(fragment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        tryDynamicBarColor();

    }

    private void setRequestedFragment(int fragNumber) {
        switch (fragNumber) {
            case 0:
                viewPager.setCurrentItem(0);
                break;
            case 1:
                viewPager.setCurrentItem(1);
                break;
            case 2:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    private void setupNavigationView() {
        //changing toolbar to actionbar and setting hamburger menu icon up top
        final Toolbar toolbar = findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        navDrawer = findViewById(R.id.drawer_layout);
        viewPager = findViewById(R.id.htab_viewpager);
        tabLayout = findViewById(R.id.htab_tablayout);
        collapsingToolbarLayout = findViewById(R.id.htab_collapse_toolbar);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar,
                R.string.app_name, R.string.appbar_scrolling_view_behavior);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    void setUpTabs() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new LandmarksFragment());
        adapter.addFragment(new EateryFragment());
        adapter.addFragment(new ShoppingFragment());
        adapter.addFragment(new ExcursionsFragment());
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_landmarks);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_eatery);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_shopping);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_excursions);
    }


    private void tryDynamicBarColor() {
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chhatri_baug);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(Palette palette) {

                    mutedColor = palette.getMutedColor(R.color.colorPrimary);
                    int darkMutedColor = palette.getDarkMutedColor(R.color.colorPrimaryDark);

                    int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                    int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);

                    collapsingToolbarLayout.setContentScrimColor(mutedColor);
                    collapsingToolbarLayout.setStatusBarScrimColor(darkMutedColor);

                    collapsingToolbarLayout.setFitsSystemWindows(true);

                    View header = navigationView.getHeaderView(0);
                    navHeader = header.findViewById(R.id.nav_header);
                    navHeader.setBackgroundColor(mutedColor);

                }
            });

        } catch (Exception e) {
            // if Bitmap fetch fails, fallback to primary colors
            Log.e("LOG", "onCreate: failed to create bitmap from background", e.fillInStackTrace());
            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimaryDark)
            );
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent navIntent = new Intent(MainActivity.this, NavigationActivity.class);

        //Fra fragment = null;

        if (id == R.id.nav_landmarks) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.nav_eatery) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.nav_shopping) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.nav_excursions) {
            viewPager.setCurrentItem(3);
        } else if (id == R.id.nav_about_city) {
            navIntent.putExtra("NAV_ITEM", "4");
            startActivity(navIntent);
        } else if (id == R.id.nav_history) {
            navIntent.putExtra("NAV_ITEM", "5");
            startActivity(navIntent);
        } else if (id == R.id.nav_culture) {
            navIntent.putExtra("NAV_ITEM", "6");
            startActivity(navIntent);
        } else if (id == R.id.nav_how_to_reach) {
            navIntent.putExtra("NAV_ITEM", "7");
            startActivity(navIntent);
        }

        navDrawer = findViewById(R.id.drawer_layout);
        navDrawer.closeDrawer(Gravity.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        assert navDrawer != null;
        if (navDrawer.isDrawerOpen(GravityCompat.START))
            navDrawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

}