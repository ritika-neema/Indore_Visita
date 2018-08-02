package com.ritikaneema.indorevisita;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.ritikaneema.indorevisita.MainActivity.mutedColor;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView content, heading;
    DrawerLayout navDrawer;
    NavigationView navigationView;
    Intent resultIntent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int navItem = Integer.parseInt(getIntent().getStringExtra("NAV_ITEM"));

        setContentView(R.layout.activity_navigation);

        setNavigationView();

        content = findViewById(R.id.venue_description);
        heading = findViewById(R.id.venue_location_detail);

        switch (navItem) {
            case 4:
                heading.setText(R.string.title_about_city);
                content.setText(R.string.about_city);
                break;
            case 5:
                heading.setText(R.string.title_city_history);
                content.setText(R.string.city_history);
                break;
            case 6:
                heading.setText(R.string.title_city_culture);
                content.setText(R.string.city_culture);
                break;
            case 7:
                heading.setText(R.string.title_how_to_reach);
                content.setText(R.string.how_to_reach);
                break;
            default:
                heading.setText("");
                content.setText("");
                break;
        }

        TextView website = findViewById(R.id.venue_website);
        website.setVisibility(View.GONE);
        FloatingActionButton fab = findViewById(R.id.venue_map);
        fab.setVisibility(View.GONE);

    }

    public void setNavigationView(){

        final Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        navDrawer = findViewById(R.id.drawer_layout_nav);

        //Set listener to navigation view
        navigationView = findViewById(R.id.nav_view_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        LinearLayout navHeader = header.findViewById(R.id.nav_header);
        navHeader.setBackgroundColor(mutedColor);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar,
                R.string.app_name, R.string.appbar_scrolling_view_behavior);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void setResultIntent() {
        resultIntent.putExtras(bundle);
        startActivity(resultIntent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        resultIntent = new Intent(NavigationActivity.this, MainActivity.class);
        bundle = new Bundle();

        if (id == R.id.nav_landmarks) {
            bundle.putString("FRAGMENT", "0");
            setResultIntent();
        } else if (id == R.id.nav_eatery) {
            bundle.putString("FRAGMENT", "1");
            setResultIntent();
        } else if (id == R.id.nav_shopping) {
            bundle.putString("FRAGMENT", "2");
            setResultIntent();
        } else if (id == R.id.nav_excursions) {
            bundle.putString("FRAGMENT", "3");
            setResultIntent();
        } else if (id == R.id.nav_about_city) {
            heading.setText(R.string.title_about_city);
            content.setText(R.string.about_city);
        } else if (id == R.id.nav_history) {
            heading.setText(R.string.title_city_history);
            content.setText(R.string.city_history);
        } else if (id == R.id.nav_culture) {
            heading.setText(R.string.title_city_culture);
            content.setText(R.string.city_culture);
        } else if (id == R.id.nav_how_to_reach) {
            heading.setText(R.string.title_how_to_reach);
            content.setText(R.string.how_to_reach);
        }

        navDrawer = findViewById(R.id.drawer_layout_nav);
        navDrawer.closeDrawer(Gravity.START);
        return true;
    }
}
