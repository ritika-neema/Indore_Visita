package com.ritikaneema.indorevisita;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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
        TextView selectedVenueVillageTextView = findViewById(R.id.venue_location_detail);
        TextView selectedVenueVolcanoTextView = findViewById(R.id.venue_timing);
        TextView selectedVenueWebsiteTextView = findViewById(R.id.venue_website);
        TextView selectedVenueFeaturesTextView = findViewById(R.id.venue_fee);
        ImageView selectedVenueImageView = findViewById(R.id.backdrop);
        ImageView selectedVenueMapImageView = findViewById(R.id.venue_map);

        // Set the TextViews to the BUNDLE values for the selected Venue

        selectedVenueTitleTextView.setText(venueTitle);

        selectedVenueIntroTextView.setText(venueDescription);

        selectedVenueVillageTextView.setText(venueLocation);


        selectedVenueVolcanoTextView.setText(venueTiming);


        if (venueWebsite.equals("") || venueWebsite.equals("")) {
            selectedVenueWebsiteTextView.setVisibility(View.GONE);
        } else {
            selectedVenueWebsiteTextView.setText(venueWebsite);
        }

        if (venueFee.equals("") || venueFee.equals("")) {
            selectedVenueFeaturesTextView.setVisibility(View.GONE);
        } else {
            selectedVenueFeaturesTextView.setText(venueFee);
        }

        // Check if there is a url and display the map locator button if there is
        if (venueMapUrl.equals("") || venueMapUrl.equals("")) {
            selectedVenueMapImageView.setVisibility(View.INVISIBLE);
        }

        // Display the venue image
        selectedVenueImageView.setImageResource(venueImage);

        // Set up the custom toolbar and back button
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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
