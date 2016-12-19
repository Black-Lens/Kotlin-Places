package com.blacklenspub.kotlinplaces.presentation;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;
import com.blacklenspub.kotlinplaces.data.entity.Place;

import java.util.List;

public class PlaceListPresenter {

    private PlaceListViewAction mViewAction;
    private PlaceDataSource mDataSource;

    // TODO : get repo
    public PlaceListPresenter(PlaceListViewAction viewAction,
                              PlaceDataSource dataSource) {
        mViewAction = viewAction;
        mDataSource = dataSource;
    }

    public void getPlaceList() {
        // TODO : get place list from repo then return to ViewAction
        mDataSource.getPlaceList(new PlaceDataSource.LoadPlaceListCallback() {

            @Override
            public void onPlaceListLoaded(List<Place> places) {
                mViewAction.setPlaceList(places);
            }

            @Override
            public void onPlacesListNotAvailable() {
                // TODO : notify viewAction
            }
        });
    }

}
