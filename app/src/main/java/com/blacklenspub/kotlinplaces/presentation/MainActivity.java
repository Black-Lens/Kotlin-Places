package com.blacklenspub.kotlinplaces.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.blacklenspub.kotlinplaces.Injection;
import com.blacklenspub.kotlinplaces.R;
import com.blacklenspub.kotlinplaces.data.entity.Place;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements PlaceListViewAction, AdapterView.OnItemSelectedListener {

    private PlaceListPresenter mPresenter;

    private Spinner spPlaceTypes;
    private RecyclerView rvPlaces;
    private PlaceAdapter mPlaceAdapter;
    private ArrayAdapter<CharSequence> mFilterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSpinner();
        setupRecyclerView();

        mPresenter = new PlaceListPresenter(this, Injection.providePlaceDataSource());
        mPresenter.getAllPlaces();
    }

    private void setupSpinner() {
        mFilterAdapter = ArrayAdapter.createFromResource(this,
                R.array.places_types, android.R.layout.simple_spinner_item);
        mFilterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPlaceTypes = (Spinner) findViewById(R.id.spPlaceType);
        spPlaceTypes.setAdapter(mFilterAdapter);
        spPlaceTypes.setOnItemSelectedListener(this);
    }

    private void setupRecyclerView() {
        rvPlaces = (RecyclerView) findViewById(R.id.rvPlaces);
        rvPlaces.setHasFixedSize(true);
        rvPlaces.setLayoutManager(new LinearLayoutManager(this));
        mPlaceAdapter = new PlaceAdapter(null);
        rvPlaces.setAdapter(mPlaceAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CharSequence filter = mFilterAdapter.getItem(i);
        if (filter != null) {
            if (filter.equals("All")) {
                mPresenter.getAllPlaces();
            } else if (filter.equals("Hotel")) {
                mPresenter.getPlacesByType(Place.Type.HOTEL);
            } else if (filter.equals("Restaurant")) {
                mPresenter.getPlacesByType(Place.Type.RESTAURANT);
            } else if (filter.equals("Shopping")) {
                mPresenter.getPlacesByType(Place.Type.SHOPPING);
            } else if (filter.equals("Landmark")) {
                mPresenter.getPlacesByType(Place.Type.LANDMARK);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO : show all places
    }

    @Override
    public void setPlaceList(List<Place> places) {
        mPlaceAdapter.setPlaces(places);
    }

    private class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder {

            public TextView tvPlaceName;

            public ViewHolder(View view) {
                super(view);
                tvPlaceName = (TextView) view.findViewById(R.id.tvPlaceName);
            }

        }

        private List<Place> mPlaces;

        public PlaceAdapter(List<Place> places) {
            mPlaces = places;
        }

        public void setPlaces(List<Place> places) {
            mPlaces = places;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvPlaceName.setText(mPlaces.get(position).getName());
        }

        @Override
        public int getItemCount() {
            if (mPlaces != null) {
                return mPlaces.size();
            } else {
                return 0;
            }
        }

    }

}
