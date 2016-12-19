package com.blacklenspub.kotlinplaces;

import android.content.Context;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;

// Injection for MOCK
public class Injection {

    public static PlaceDataSource providePlaceDataSource(Context context) {
        return new MockDataSource(context);
    }

}
