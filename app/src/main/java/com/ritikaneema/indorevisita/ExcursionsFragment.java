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

public class ExcursionsFragment extends Fragment {
    public ArrayList<Venue> excursionsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_tabs, container, false);

        excursionsList.clear();

        excursionsList.add(new Venue(getString(R.string.excursion1_title),
                getString(R.string.excursion1_description),
                getString(R.string.excursion1_location),
                getString(R.string.excursion1_maps),
               getString(R.string.excursion1_timing),getString(R.string.excursion1_website),getString(R.string.excursion1_fee),
                R.drawable.nakhrali));

        excursionsList.add(new Venue(getString(R.string.excursion2_title),
                getString(R.string.excursion2_description),
                getString(R.string.excursion2_location),
                getString(R.string.excursion2_maps),
                getString(R.string.excursion2_timings),"",getString(R.string.excursion2_fee),
                R.drawable.pipliyapala_regional));

        excursionsList.add(new Venue(getString(R.string.excursion3_title),
                getString(R.string.excursion3_description),
                getString(R.string.excursion3_location),
                getString(R.string.excursion3_maps),
                "","","",
                R.drawable.tinchawaterfalls));

        excursionsList.add(new Venue(getString(R.string.excursion4_title),
                getString(R.string.excursion4_description),
                getString(R.string.excursion4_location),
                getString(R.string.excursion4_maps),
                "","","",
                R.drawable.choraldam));

        excursionsList.add(new Venue(getString(R.string.excursion5_title),
                getString(R.string.excursion5_description),
                getString(R.string.excursion5_location),
                getString(R.string.excursion5_maps),
                getString(R.string.excursion5_timings),getString(R.string.excursion5_website),
                "", R.drawable.crescent));

        excursionsList.add(new Venue(getString(R.string.excursion6_title),
                getString(R.string.excursion6_description),
                getString(R.string.excursion6_location),
                getString(R.string.excursion6_maps),
                "","", "",
                R.drawable.patalpani));


        RecyclerView recyclerView =  rootview.findViewById(R.id.frag_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        VenueRecyclerAdapter adapter = new VenueRecyclerAdapter(rootview.getContext(),excursionsList);
        recyclerView.setAdapter(adapter);

        return rootview;
    }
}
