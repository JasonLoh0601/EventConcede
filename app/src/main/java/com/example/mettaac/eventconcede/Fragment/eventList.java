package com.example.mettaac.eventconcede.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mettaac.eventconcede.R;
import com.example.mettaac.eventconcede.data.attractionDetail;
import com.example.mettaac.eventconcede.data.eventDetail;
import com.example.mettaac.eventconcede.listView.listVIewAdapter;
import com.example.mettaac.eventconcede.listView.listViewAdapter2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonLoh95 on 8/1/2018.
 */

public class eventList extends Fragment {
    ListView listViewEvent;
    DatabaseReference databaseEvent;
    private Activity context;
    List<eventDetail> event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.event, container, false);

        databaseEvent = FirebaseDatabase.getInstance().getReference().child("listEvent");
        listViewEvent = (ListView) rootView.findViewById(R.id.event);

        event = new ArrayList<>();

        return rootView;
    }

    public void onStart() {
        super.onStart();
        //attaching value event listener
        databaseEvent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                event.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    eventDetail a = postSnapshot.getValue(eventDetail.class);
                    //adding artist to the list
                    event.add(a);
                }

                //creating adapter
                listViewAdapter2 eventAdapter = new listViewAdapter2(getActivity(), event);
                //attaching adapter to the listview
                listViewEvent.setAdapter(eventAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
