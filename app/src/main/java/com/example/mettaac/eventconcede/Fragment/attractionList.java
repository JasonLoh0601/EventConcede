package com.example.mettaac.eventconcede.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mettaac.eventconcede.R;
import com.example.mettaac.eventconcede.data.attractionDetail;
import com.example.mettaac.eventconcede.listView.listVIewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonLoh95 on 7/1/2018.
 */

public class attractionList extends android.support.v4.app.Fragment {

    ListView listViewAttraction;
    DatabaseReference databaseAttraction;
    private Activity context;
    List<attractionDetail> attractions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attrations, container, false);

        databaseAttraction = FirebaseDatabase.getInstance().getReference().child("listAttractions");
        listViewAttraction = (ListView) rootView.findViewById(R.id.attraction);

        attractions = new ArrayList<>();

        return rootView;
    }

    public void onStart() {
        super.onStart();
        //attaching value event listener
        databaseAttraction.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                attractions.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    attractionDetail a = postSnapshot.getValue(attractionDetail.class);
                    //adding artist to the list
                    attractions.add(a);
                }

                //creating adapter
                listVIewAdapter attractionAdapter = new listVIewAdapter(getActivity(), attractions);
                //attaching adapter to the listview
                listViewAttraction.setAdapter(attractionAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
