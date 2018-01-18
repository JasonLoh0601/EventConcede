package com.example.mettaac.eventconcede;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mettaac.eventconcede.Maps.MapsActivity;

public class attractionPage extends AppCompatActivity  {

    TextView Hour;
    TextView website;
    TextView contactNumber;
    TextView address;
    TextView price;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_detail);

        Intent i = this.getIntent();



        final String attractionName1 = i.getExtras().getString("NAME_KEY");
        final String Hour1 = i.getExtras().getString("HOURS_KEY");
        final String website1 = i.getExtras().getString("WEBSITE_KEY");
        final String contactNumber1 = i.getExtras().getString("PHONE_KEY");
        final String address1 = i.getExtras().getString("LOCATION_KEY");
        final String payment = i.getExtras().getString("PAYMENT_KEY");
        String price1 = i.getExtras().getString("PRICE_KEY");
        String photo = i.getExtras().getString("PHOTO_KEY");


        Hour = (TextView) findViewById(R.id.Date);
        website = (TextView) findViewById(R.id.Website);
        contactNumber = (TextView) findViewById(R.id.contactNumber);
        address = (TextView) findViewById(R.id.Address);
        price = (TextView) findViewById(R.id.price);
        imageView = (ImageView) findViewById(R.id.imageView2) ;


        contactNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+contactNumber1));
                startActivity(callIntent);
            }

        });

        website.setPaintFlags(website.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        contactNumber.setPaintFlags(contactNumber.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(website1);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });


        setTitle(attractionName1);

        Glide.with(this).load(photo).into(imageView);
        Hour.setText(Hour1);
        website.setText(website1);
        contactNumber.setText(contactNumber1);
        address.setText(address1);
        price.setText(price1);

        Button direction = (Button) findViewById(R.id.button2);
        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (attractionPage.this,MapsActivity.class);
                i.putExtra("LOCATION_KEY",address1);
                startActivity(i);
            }
        });

        Button makePayment = (Button) findViewById(R.id.button3);
        makePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(payment);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
