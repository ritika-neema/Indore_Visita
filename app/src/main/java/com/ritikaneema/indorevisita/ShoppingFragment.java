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

public class ShoppingFragment extends Fragment {

    public ArrayList<Venue> shoppingList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_dummy, container, false);

        shoppingList.clear();

        shoppingList.add(new Venue(getString(R.string.shopping1_title),
                getString(R.string.shopping1_description), getString(R.string.shopping1_location),
                getString(R.string.shopping1_maps),getString(R.string.shopping1_timings),
               "","", R.drawable.mt_cloth_market));

        shoppingList.add(new Venue(getString(R.string.shopping2_title),
                getString(R.string.shopping2_description), getString(R.string.shopping2_location),
                getString(R.string.shopping2_maps), getString(R.string.shopping2_timings),
                "","", R.drawable.sitlamata_bazaar));

        shoppingList.add(new Venue(getString(R.string.shopping5_title),
                getString(R.string.shopping5_description), getString(R.string.shopping5_location),
                getString(R.string.shopping5_maps), getString(R.string.shopping5_timings),
                getString(R.string.shopping5_website),"",
                R.drawable.ctwoone));

        shoppingList.add(new Venue(getString(R.string.shopping6_title),
                getString(R.string.shopping6_description), getString(R.string.shopping6_location),
                getString(R.string.shopping6_maps), getString(R.string.shopping6_timings),
                getString(R.string.shopping6_website),"",
                R.drawable.shopersstopw));

        shoppingList.add(new Venue(getString(R.string.shopping3_title),
                getString(R.string.shopping3_description), getString(R.string.shopping3_location),
                getString(R.string.shopping3_maps), getString(R.string.shopping3_timings),
                "","",
                R.drawable.ti));

        shoppingList.add(new Venue(getString(R.string.shopping4_title),
                getString(R.string.shopping4_description), getString(R.string.shopping4_location),
                getString(R.string.shopping4_maps), getString(R.string.shopping4_timings),
                getString(R.string.shopping4_website),"",
                R.drawable.mrignayani_showroom));


        RecyclerView recyclerView =  rootview.findViewById(R.id.frag_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);

        VenueRecyclerAdapter adapter = new VenueRecyclerAdapter(rootview.getContext(), shoppingList);
        recyclerView.setAdapter(adapter);


        return rootview;
    }

}
