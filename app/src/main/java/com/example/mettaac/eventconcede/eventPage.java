package com.example.mettaac.eventconcede;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mettaac.eventconcede.Maps.MapsActivity;

/**
 * Created by JasonLoh95 on 7/1/2018.
 */

public class eventPage extends AppCompatActivity {

    TextView eventName;
    TextView Hour;
    TextView website;
    TextView address;
    TextView description;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        Intent i = this.getIntent();

        final String eventName1 = i.getExtras().getString("NAME_KEY");
        final String Hour1 = i.getExtras().getString("HOURS_KEY");
        String website1 = i.getExtras().getString("WEBSITE_KEY");
        final String address1 = i.getExtras().getString("LOCATION_KEY");
        String description1 = i.getExtras().getString("DESCRIPTION_KEY");
        String photo = i.getExtras().getString("PHOTO_KEY");

        Hour = (TextView) findViewById(R.id.Date);
        website = (TextView) findViewById(R.id.Website);
        address = (TextView) findViewById(R.id.Address);
        description = (TextView) findViewById(R.id.description1);
        imageView = (ImageView) findViewById(R.id.imageView2) ;

        website.setPaintFlags(website.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        setTitle(eventName1);

        Glide.with(this).load(photo).into(imageView);
        Hour.setText(Hour1);
        website.setText(website1);
        address.setText(address1);
        description.setText(description1);

        Button direction = (Button) findViewById(R.id.button2);
        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (eventPage.this,MapsActivity.class);
                i.putExtra("LOCATION_KEY",address1);
                startActivity(i);
            }
        });
    }
}
