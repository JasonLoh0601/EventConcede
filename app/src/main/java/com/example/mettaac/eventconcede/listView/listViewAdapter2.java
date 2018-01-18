package com.example.mettaac.eventconcede.listView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mettaac.eventconcede.R;
import com.example.mettaac.eventconcede.attractionPage;
import com.example.mettaac.eventconcede.data.attractionDetail;
import com.example.mettaac.eventconcede.data.eventDetail;
import com.example.mettaac.eventconcede.eventPage;

import java.util.List;

/**
 * Created by JasonLoh95 on 8/1/2018.
 */

public class listViewAdapter2  extends ArrayAdapter<eventDetail> {

    LayoutInflater inflater;
    private Activity context;
    List<eventDetail> event;

    public listViewAdapter2(Activity context, List<eventDetail> event) {
        super(context, R.layout.list_event, event);
        this.context = context;
        this.event = event;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView= inflater.inflate(R.layout.list_event,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);

        final String eventName = event.get(position).getEventName();
        final String Hours = event.get(position).getHours();
        final String website = event.get(position).getWebsite();
        final String location = event.get(position).getAddress();
        final String photo = event.get(position).getPhoto();
        final String description = event.get(position).getDescription();


        Glide.with(context).load(photo).into(imageView);
        textViewName.setText(eventName);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventDetail(eventName, Hours, website, location, photo, description);
            }
        });
        return convertView;
    }
    private void openEventDetail(String eventName, String Hours, String website, String location, String photo, String description){
        Intent i = new Intent(context, eventPage.class);

        i.putExtra("NAME_KEY",eventName);
        i.putExtra("HOURS_KEY",Hours);
        i.putExtra("WEBSITE_KEY",website);
        i.putExtra("LOCATION_KEY",location);
        i.putExtra("PHOTO_KEY",photo);
        i.putExtra("DESCRIPTION_KEY",description);

        context.startActivity(i);
    }
}


