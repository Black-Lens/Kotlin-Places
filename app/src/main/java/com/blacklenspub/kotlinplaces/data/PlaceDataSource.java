package com.blacklenspub.kotlinplaces.data;

import java.util.List;

public interface PlaceDataSource {

    interface LoadPlaceListCallback {
        void onPlaceListLoaded(List<Place> places);
        void onPlacesListNotAvailable();
    }

    void getPlaceList(LoadPlaceListCallback callback);

}
