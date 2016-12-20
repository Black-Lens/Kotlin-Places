package com.blacklenspub.kotlinplaces;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;
import com.blacklenspub.kotlinplaces.data.PlaceRepository;

public class Injection {

    public static PlaceDataSource providePlaceDataSource() {
        return new PlaceRepository();
    }

}