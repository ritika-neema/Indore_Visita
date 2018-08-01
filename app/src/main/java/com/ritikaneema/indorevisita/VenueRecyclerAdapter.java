package com.ritikaneema.indorevisita;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VenueRecyclerAdapter extends RecyclerView.Adapter<VenueRecyclerAdapter.ViewHolder> {

    private List<Venue> venueData;
    private LayoutInflater layoutInflater;

    public VenueRecyclerAdapter(Context context, ArrayList<Venue> venueData) {
        this.layoutInflater = LayoutInflater.from(context);
        this.venueData = venueData;
    }

    @Override
    public VenueRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = layoutInflater.inflate(R.layout.recycler_item, null);
        return  new ViewHolder(itemLayoutView);

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final Venue currentVenue = venueData.get(position);

        //Assign the values of your ArrayList to the assigned holder views
        viewHolder.venueTitle.setText(currentVenue.getmTitle());
        viewHolder.venueLocation.setText(currentVenue.getmLocation());
        viewHolder.venuePhotoId.setImageResource(currentVenue.getmPhotoId());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent venueDetailsIntent = new Intent(v.getContext(), DetailsActivity.class);

                // Add the venue details BUNDLE to be sent to DetailActivity
                venueDetailsIntent.putExtra("VENUE_TITLE", currentVenue.getmTitle());
                venueDetailsIntent.putExtra("VENUE_DESCRIPTION",
                        currentVenue.getmDescription());
                venueDetailsIntent.putExtra("VENUE_LOCATION", currentVenue.getmLocation());
                venueDetailsIntent.putExtra("VENUE_TIMING", currentVenue.getmTiming());
                venueDetailsIntent.putExtra("VENUE_WEBSITE", currentVenue.getmWebsite());
                venueDetailsIntent.putExtra("VENUE_FEE", currentVenue.getmFee());
                venueDetailsIntent.putExtra("VENUE_IMAGE", currentVenue.getmPhotoId());
                venueDetailsIntent.putExtra("VENUE_MAP_URL", currentVenue.getmMapUrl());

                v.getContext().startActivity(venueDetailsIntent);
            }
        });

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView venueTitle;
        private TextView venueLocation;
        private ImageView venuePhotoId;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            venueTitle = itemLayoutView.findViewById(R.id.venue_title);
            venueLocation = itemLayoutView.findViewById(R.id.venue_location);
            venuePhotoId = itemLayoutView.findViewById(R.id.venue_photo);
        }
    }

    @Override
    public int getItemCount() {
        return venueData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}