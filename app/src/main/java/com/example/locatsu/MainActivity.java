package com.example.locatsu;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.locatsu.adapter.LocationListAdapter;
import com.example.locatsu.db.DatabaseHelper;
import com.example.locatsu.model.Location;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private final LocationData locationData = LocationData.getInstance();
    private LocationListAdapter mAdapter;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        locationData.locationList = new ArrayList<>();

        mHelper = new DatabaseHelper(this);
        mDatabase = mHelper.getWritableDatabase();

        Cursor cursor = mDatabase.query(
                DatabaseHelper.TABLE_name,
                null,
                null,
                null,
                null,
                null,
                null

        );
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_name));
            String picture = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_picture));
            String detail = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_detail));
            locationData.locationList.add(new Location(name, picture, detail));

        }
        mAdapter = new LocationListAdapter(
                this,
                R.layout.item,
                locationData.locationList
        );

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Location location = locationData.locationList.get(i);
                Toast.makeText(MainActivity.this,location.name,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, LoicationDetails.class);
                intent.putExtra("position", i);

                startActivity(intent);
            }
        });

    }

}
