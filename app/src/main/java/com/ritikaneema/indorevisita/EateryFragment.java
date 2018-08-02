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

public class EateryFragment extends Fragment {

    public ArrayList<Venue> eateryList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_tabs, container, false);

        eateryList.clear();

        eateryList.add(new Venue(getString(R.string.eatery1_title),
                getString(R.string.eatery1_description), getString(R.string.eatery1_location),
                getString(R.string.eatery1_maps), getString(R.string.eatery1_timings),
                "",getString(R.string.eatery1_fee),
                R.drawable.sarafa));

        eateryList.add(new Venue(getString(R.string.eatery2_title),
                getString(R.string.eatery2_description), getString(R.string.eatery2_location),
                getString(R.string.eatery2_maps), "","",getString(R.string.eatery2_fee),
                R.drawable.indore_chappan));

        eateryList.add(new Venue(getString(R.string.eatery3_title),
                getString(R.string.eatery3_description), getString(R.string.eatery3_location),
                getString(R.string.eatery3_maps), "",
                getString(R.string.eatery3_website),"",
                R.drawable.shreemaya));

        eateryList.add(new Venue(getString(R.string.eatery4_title),
                getString(R.string.eatery4_description), getString(R.string.eatery4_location),
                getString(R.string.eatery4_maps), getString(R.string.eatery4_timings),
                getString(R.string.eatery4_website),"",
                R.drawable.celebration));

        eateryList.add(new Venue(getString(R.string.eatery5_title),
                getString(R.string.eatery5_description), getString(R.string.eatery5_location),
                getString(R.string.eatery5_maps), getString(R.string.eatery5_timings),
                getString(R.string.eatery5_website),"",
                R.drawable.go_bana));

        eateryList.add(new Venue(getString(R.string.eatery6_title),
                getString(R.string.eatery6_description), getString(R.string.eatery6_location),
                getString(R.string.eatery6_maps), getString(R.string.eatery6_timings),
                "","",
                R.drawable.mug_and_beans));

        eateryList.add(new Venue(getString(R.string.eatery7_title),
                getString(R.string.eatery7_description), getString(R.string.eatery7_location),
                getString(R.string.eatery7_maps), getString(R.string.eatery7_timings),
                "","",
                R.drawable.ich));

        RecyclerView recyclerView =  rootview.findViewById(R.id.frag_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        VenueRecyclerAdapter adapter = new VenueRecyclerAdapter(rootview.getContext(),eateryList);
        recyclerView.setAdapter(adapter);

        return rootview;
    }
}
