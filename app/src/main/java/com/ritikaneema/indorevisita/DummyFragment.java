package com.ritikaneema.indorevisita;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class DummyFragment extends Fragment {

    int color;
    public ArrayList<Venue> VenuesDatabase = new ArrayList<>();

    public DummyFragment() {

    }

    @SuppressLint("ValidFragment")
    public DummyFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_dummy, container, false);

        VenuesDatabase.clear();

        //Create the ArrayList data
        VenuesDatabase.add(new Venue(
                "venue_9_title",
                "venue_9_intro",
                ".venue_9_village",
                "venue_9_volcano",
                "venue_9_website_url",
                "venue_9_features_services",
                "venue_9_map_url",
                R.drawable.ic_launcher_foreground));
        VenuesDatabase.add(new Venue(
                "venue_9_title",
                "venue_9_intro",
                ".venue_9_village",
                "venue_9_volcano",
                "venue_9_website_url",
                "venue_9_features_services",
                "venue_9_map_url",
                R.drawable.ic_launcher_foreground));
        VenuesDatabase.add(new Venue(
                "venue_9_title",
                "venue_9_intro",
                ".venue_9_village",
                "venue_9_volcano",
                "venue_9_website_url",
                "venue_9_features_services",
                "venue_9_map_url",
                R.drawable.ic_launcher_foreground));

        final FrameLayout frameLayout = rootview.findViewById(R.id.dummyfrag_bg);
        frameLayout.setBackgroundColor(color);

        RecyclerView recyclerView =  rootview.findViewById(R.id.frag_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        VenueRecyclerAdapter adapter = new VenueRecyclerAdapter(rootview.getContext(),VenuesDatabase);
        recyclerView.setAdapter(adapter);

        return rootview;
    }

}