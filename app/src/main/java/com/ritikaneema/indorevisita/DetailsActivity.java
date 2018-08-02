package com.ritikaneema.indorevisita;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;

    TextView selectedVenueLocationTextView, selectedVenueTimingTextView;
    ImageView selectedVenueImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setContentAndBehaviour();

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);

        setupToolBar();


    }

    private void setContentAndBehaviour() {

        // Venue details BUNDLE from MainActivity
        final String venueTitle = getIntent().getStringExtra("VENUE_TITLE");
        final String venueDescription = getIntent().getStringExtra("VENUE_DESCRIPTION");
        final String venueLocation = getIntent().getStringExtra("VENUE_LOCATION");
        final String venueTiming = getIntent().getStringExtra("VENUE_TIMING");
        final String venueWebsite = getIntent().getStringExtra("VENUE_WEBSITE");
        final String venueFee = getIntent().getStringExtra("VENUE_FEE");
        final int venueImage = getIntent().getIntExtra("VENUE_IMAGE", 0);
        final String venueMapUrl = getIntent().getStringExtra("VENUE_MAP_URL");

        // Find the views for selected Venue
        TextView selectedVenueTitleTextView = findViewById(R.id.toolbar_title);
        TextView selectedVenueIntroTextView = findViewById(R.id.venue_description);
        selectedVenueLocationTextView = findViewById(R.id.venue_location_detail);
        selectedVenueTimingTextView = findViewById(R.id.venue_timing);
        TextView selectedVenueWebsiteTextView = findViewById(R.id.venue_website);
        TextView selectedVenueFeesTextView = findViewById(R.id.venue_fee);
        selectedVenueImageView = findViewById(R.id.backdrop);
        ImageView selectedVenueMapImageView = findViewById(R.id.venue_map);

        // Set the TextViews for the selected Venue
        selectedVenueTitleTextView.setText(venueTitle);
        selectedVenueIntroTextView.setText(venueDescription);
        selectedVenueLocationTextView.setText(venueLocation);
        selectedVenueTimingTextView.setText(venueTiming);

        if (venueWebsite.equals("") || venueWebsite.equals("")) {
            selectedVenueWebsiteTextView.setVisibility(View.GONE);
        } else {
            selectedVenueWebsiteTextView.setText(venueWebsite);
        }

        if (venueFee.equals("") || venueFee.equals("")) {
            selectedVenueFeesTextView.setVisibility(View.GONE);
        } else {
            selectedVenueFeesTextView.setText(venueFee);
        }

        // Check if there is a url and display the map button if there is
        if (venueMapUrl.equals("") || venueMapUrl.equals("")) {
            selectedVenueMapImageView.setVisibility(View.INVISIBLE);
        }

        // Display the venue image
        selectedVenueImageView.setImageResource(venueImage);

        tryDynamicBarColor(venueImage);

        // Launch website in browser when url button is clicked
        findViewById(R.id.venue_website).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(venueWebsite));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        // Launch maps when map button is clicked
        findViewById(R.id.venue_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapUri = Uri.parse(venueMapUrl);

                Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void setupToolBar() {
        // Set up the custom toolbar and back button
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    private void tryDynamicBarColor(int imageId) {
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(Palette palette) {

                    int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);

                    collapsingToolbarLayout.setContentScrimColor(vibrantDarkColor);
                    collapsingToolbarLayout.setStatusBarScrimColor(
                            getResources().getColor(R.color.transparent_00));

                    collapsingToolbarLayout.setFitsSystemWindows(true);

                    selectedVenueLocationTextView.setBackgroundColor(vibrantDarkColor);
                    selectedVenueTimingTextView.setBackgroundColor(vibrantDarkColor);

                }
            });

        } catch (Exception e) {

            // if Bitmap fetch fails, fallback to primary colors
            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimaryDark)
            );

        }
    }

    // Make the Up Button behave like a Back Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

}
