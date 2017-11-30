package com.example.locatsu.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TO_MANG on 30/11/2560.
 */

public class Location {
    public  final String name;
    public  final String picture;
    public  final String detail;

    public Location(String name, String picture, String detail) {
        this.name = name;
        this.picture = picture;
        this.detail = detail;
    }

    public Drawable getPictureDrawable(Context context){
        AssetManager lc = context.getAssets();

        try {
            InputStream inputStream = lc.open(picture);
            Drawable drawable = Drawable.createFromStream(inputStream, "");
            return drawable;
        } catch (IOException e){
            Log.e("Location","Error Opennung File : " + picture);
            e.printStackTrace();
            return null;
        }
    }
}
