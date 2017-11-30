package com.example.locatsu;



import com.example.locatsu.model.Location;

import java.util.ArrayList;

/**
 * Created by TO_MANG on 30/11/2560.
 */

public class LocationData {

    private static LocationData dInstance;
    public ArrayList<Location> locationList;

    public static LocationData getInstance(){
        if(dInstance == null){
            dInstance = new LocationData();
        }
        return dInstance;
    }
}
