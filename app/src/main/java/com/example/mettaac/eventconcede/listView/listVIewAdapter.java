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

import java.util.List;

/**
 * Created by JasonLoh95 on 7/1/2018.
 */

public class listVIewAdapter extends ArrayAdapter<attractionDetail> {

    LayoutInflater inflater;
    private Activity context;
    List<attractionDetail> attraction;

    public listVIewAdapter(Activity context, List<attractionDetail> attraction) {
        super(context, R.layout.list_attractiont, attraction);
        this.context = context;
        this.attraction = attraction;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView= inflater.inflate(R.layout.list_attractiont,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView textViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);

        final String attractionName = attraction.get(position).getAttractionName();
        final String Hours = attraction.get(position).getHours();
        final String website = attraction.get(position).getWebsite();
        final String contactNumber = attraction.get(position).getPhone();
        final String location = attraction.get(position).getAddress();
        final String photo = attraction.get(position).getPhoto();
        final String price = attraction.get(position).getPrice();
        final String payment = attraction.get(position).getPayment();


       Glide.with(context).load(photo).into(imageView);
        textViewName.setText(attractionName);
        textViewPrice.setText(price);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAttractionDetail(attractionName, Hours, website, contactNumber, location, photo, price,payment);
            }
        });
        return convertView;
    }

    private void openAttractionDetail(String attractionName, String Hours, String website, String contactNumber, String location, String photo, String price, String payment){
        Intent i = new Intent(context, attractionPage.class);

        i.putExtra("NAME_KEY",attractionName);
        i.putExtra("HOURS_KEY",Hours);
        i.putExtra("WEBSITE_KEY",website);
        i.putExtra("PHONE_KEY",contactNumber);
        i.putExtra("LOCATION_KEY",location);
        i.putExtra("PHOTO_KEY",photo);
        i.putExtra("PRICE_KEY",price);
        i.putExtra("PAYMENT_KEY",payment);

        context.startActivity(i);
    }


}
