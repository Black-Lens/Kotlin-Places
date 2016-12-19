package com.blacklenspub.kotlinplaces.data;

import com.blacklenspub.kotlinplaces.data.entity.Place;

import java.util.List;

public interface PlaceDataSource {

    interface LoadPlaceListCallback {
        void onPlaceListLoaded(List<Place> places);
        void onPlacesListNotAvailable();
    }

    void getPlaceList(LoadPlaceListCallback callback);

}
