package com.example.locatsu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locatsu.LocationData;
import com.example.locatsu.R;

/**
 * Created by TO_MANG on 30/11/2560.
 */

public class LoicationDetails extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detial);

        ImageView locationImageView = findViewById(R.id.locationImageView);
        TextView detailTextView = findViewById(R.id.detailTextView);

        Intent intent = getIntent();
        int position = intent.getIntExtra("positon",0);
        LocationData locationData = LocationData.getInstance();
        com.example.locatsu.model.Location location = locationData.locationList.get(position);

        String name = location.name;
        String detail = location.detail;
        Drawable drawable = location.getPictureDrawable(this);

        locationImageView.setImageDrawable(drawable);
        detailTextView.setText(detail);

        getActionBar().setTitle(name);



    }
}
