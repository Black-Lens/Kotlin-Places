package com.blacklenspub.kotlinplaces;

import com.blacklenspub.kotlinplaces.data.PlaceDataSource;

// Injection for MOCK
public class Injection {

    public static PlaceDataSource providePlaceDataSource() {
        return new MockDataSource();
    }

}
