package com.ritikaneema.indorevisita;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LandmarksFragment extends Fragment {

    public ArrayList<Venue> landmarkList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_tabs, container, false);

        landmarkList.clear();

        landmarkList.add(new Venue(getString(R.string.landmark1_title),
                getString(R.string.landmark1_description), getString(R.string.landmark1_location),
                getString(R.string.landmark1_maps), getString(R.string.landmark1_timing),
                "", getString(R.string.landmark1_fee), R.drawable.rajwada2inore1));

        landmarkList.add(new Venue(getString(R.string.landmark2_title),
                getString(R.string.landmark2_description), getString(R.string.landmark2_location),
                getString(R.string.landmark2_maps), getString(R.string.landmark2_timing),
                "", getString(R.string.landmark2_fee), R.drawable.lalbagh_palace));

        landmarkList.add(new Venue(getString(R.string.landmark5_title),
                getString(R.string.landmark5_description), getString(R.string.landmark5_location),
                getString(R.string.landmark5_maps), getString(R.string.landmark5_timing),
                "","", R.drawable.gandhi_hall_indore));

        landmarkList.add(new Venue(getString(R.string.landmark7_title),
                getString(R.string.landmark7_description), getString(R.string.landmark7_location),
                getString(R.string.landmark7_maps), getString(R.string.landmark7_timings),
                "","", R.drawable.chhatri1));

        landmarkList.add(new Venue(getString(R.string.landmark4_title),
                getString(R.string.landmark4_description), getString(R.string.landmark4_location),
                getString(R.string.landmark4_maps), getString(R.string.landmark4_timing),
                "","", R.drawable.kanch_mandir));

        landmarkList.add(new Venue(getString(R.string.landmark3_title),
                getString(R.string.landmark3_description), getString(R.string.landmark3_location),
                getString(R.string.landmark3_maps), getString(R.string.landmark3_timing),
               "","", R.drawable.badaganapati));

        landmarkList.add(new Venue(getString(R.string.landmark6_title),
                getString(R.string.landmark6_description), getString(R.string.landmark6_location),
                getString(R.string.landmark6_maps), getString(R.string.landmark6_timings),
                "","", R.drawable.annapurna_mandir));

        landmarkList.add(new Venue(getString(R.string.landmark8_title),
                getString(R.string.landmark8_description), getString(R.string.landmark8_location),
                getString(R.string.landmark8_maps), getString(R.string.landmark8_timings),
                getString(R.string.landmark8_website),"", R.drawable.shri_khajrana_ganesh));

        landmarkList.add(new Venue(getString(R.string.landmark9_title),
                getString(R.string.landmark9_description), getString(R.string.landmark9_location),
                getString(R.string.landmark9_maps), getString(R.string.landmark9_timings),
               "","", R.drawable.gomatgiri));


        RecyclerView recyclerView =  rootview.findViewById(R.id.frag_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        VenueRecyclerAdapter adapter = new VenueRecyclerAdapter(rootview.getContext(), landmarkList);
        recyclerView.setAdapter(adapter);


        return rootview;
    }
}
