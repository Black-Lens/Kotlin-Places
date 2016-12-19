package com.blacklenspub.kotlinplaces;

import android.content.Context;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;
import com.blacklenspub.kotlinplaces.data.PlaceRepository;

public class Injection {

    public static PlaceDataSource providePlaceDataSource(Context context) {
        return new PlaceRepository();
    }

}