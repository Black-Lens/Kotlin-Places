package com.blacklenspub.kotlinplaces.presentation;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;
import com.blacklenspub.kotlinplaces.data.entity.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceListPresenter {

    private PlaceListViewAction mViewAction;
    private PlaceDataSource mDataSource;

    public PlaceListPresenter(PlaceListViewAction viewAction,
                              PlaceDataSource dataSource) {
        mViewAction = viewAction;
        mDataSource = dataSource;
    }

    public void getAllPlaces() {
        if (mDataSource != null) {
            mDataSource.getPlaceList(new PlaceDataSource.LoadPlaceListCallback() {

                @Override
                public void onPlaceListLoaded(List<Place> places) {
                    if (mViewAction != null) {
                        mViewAction.setPlaceList(places);
                    }
                }

                @Override
                public void onPlacesListNotAvailable() {
                    // TODO : notify viewAction
                }
            });
        }
    }

    public void getPlacesByType(final Place.Type type) {
        if (mDataSource != null) {
            mDataSource.getPlaceList(new PlaceDataSource.LoadPlaceListCallback() {

                @Override
                public void onPlaceListLoaded(List<Place> places) {
                    List<Place> result = filterPlaces(places, type);
                    if (mViewAction != null) {
                        mViewAction.setPlaceList(result);
                    }
                }

                @Override
                public void onPlacesListNotAvailable() {
                    // TODO : notify viewAction
                }
            });
        }
    }


    private List<Place> filterPlaces(List<Place> places, Place.Type type) {
        ArrayList<Place> result = new ArrayList<>();
        for (Place place : places) {
            if (place.getType() == type) {
                result.add(place);
            }
        }
        return result;
    }

}
