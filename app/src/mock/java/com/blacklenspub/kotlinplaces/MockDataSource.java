package com.blacklenspub.kotlinplaces;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;
import com.blacklenspub.kotlinplaces.data.entity.Place;

import java.util.ArrayList;

public class MockDataSource implements PlaceDataSource {

    @Override
    public void getPlaceList(LoadPlaceListCallback callback) {
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Centara Hotel", Place.Type.HOTEL));
        places.add(new Place("Centara Okura", Place.Type.HOTEL));

        places.add(new Place("Bonchon Chicken", Place.Type.RESTAURANT));
        places.add(new Place("KFC", Place.Type.RESTAURANT));
        places.add(new Place("Fuji", Place.Type.RESTAURANT));
        places.add(new Place("Zen", Place.Type.RESTAURANT));
        places.add(new Place("CoCo", Place.Type.RESTAURANT));
        places.add(new Place("After You", Place.Type.RESTAURANT));

        places.add(new Place("Siam Paragon", Place.Type.SHOPPING));
        places.add(new Place("Siam Center", Place.Type.SHOPPING));
        places.add(new Place("CentralWorld", Place.Type.SHOPPING));
        places.add(new Place("Central Embassy", Place.Type.SHOPPING));
        places.add(new Place("The Emquartier", Place.Type.SHOPPING));
        places.add(new Place("Chatuchak Market", Place.Type.SHOPPING));

        places.add(new Place("Victory Monument", Place.Type.LANDMARK));
        places.add(new Place("Rama VIII Bridge", Place.Type.LANDMARK));
        places.add(new Place("Democracy Monument", Place.Type.LANDMARK));

        if (callback != null) {
            callback.onPlaceListLoaded(places);
        }
    }

}
