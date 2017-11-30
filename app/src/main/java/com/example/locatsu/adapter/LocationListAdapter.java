package com.example.locatsu.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locatsu.R;
import com.example.locatsu.model.Location;
import java.util.ArrayList;

/**
 * Created by TO_MANG on 30/11/2560.
 */

public class LocationListAdapter extends ArrayAdapter<Location>{
    private Context mContext;
    private ArrayList<Location> mLocation;
    private int mLayoutResId;

    public LocationListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Location> object) {
        super(context, resource, object);
        this.mContext = context;
        this.mLayoutResId = resource ;
        this.mLocation = object;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = convertView;

        if( v == null )
            v = inflater.inflate(mLayoutResId, null);

        ImageView iv = v.findViewById(R.id.imageViewList);
        TextView tv = v.findViewById(R.id.textViewList);

        Location location = mLocation.get(position);
        Drawable drawable = mLocation.get(position).getPictureDrawable(mContext);
        iv.setImageDrawable(drawable);
        tv.setText(location.name);

        return v;
    }
}
