package com.blacklenspub.kotlinplaces;

import android.content.Context;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;

public class MockDataSource implements PlaceDataSource {

    private Context mContext;

    public MockDataSource(Context context) {
        mContext = context;
    }

    @Override
    public void getPlaceList(LoadPlaceListCallback callback) {
        // TODO : load mock data from JSON
    }

}
