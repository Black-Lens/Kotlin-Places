package com.blacklenspub.kotlinplaces.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.blacklenspub.kotlinplaces.Injection
import com.blacklenspub.kotlinplaces.R
import com.blacklenspub.kotlinplaces.data.entity.Place
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class KMainActivity : AppCompatActivity(), PlaceListViewAction, AdapterView.OnItemSelectedListener {

    lateinit var presenter: PlaceListPresenter

    lateinit var filterAdapter: ArrayAdapter<CharSequence>
    lateinit var placeAdapter: PlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()
        setupRecyclerView()

        presenter = PlaceListPresenter(this, Injection.providePlaceDataSource())
        presenter.getAllPlaces()
    }

    private fun setupSpinner() {
        filterAdapter = ArrayAdapter.createFromResource(this,
                R.array.places_types, android.R.layout.simple_spinner_item)
        filterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spPlaceType.apply {
            adapter = filterAdapter
            onItemSelectedListener = this@KMainActivity
        }
    }

    private fun setupRecyclerView() {
        rvPlaces.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@KMainActivity)
            placeAdapter = PlaceAdapter(listOf())
            rvPlaces.adapter = placeAdapter
        }
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val filter = filterAdapter.getItem(position)
        when (filter) {
            "All" -> presenter.getAllPlaces()
            "Hotel" -> presenter.getPlacesByType(Place.Type.HOTEL)
            "Restaurant" -> presenter.getPlacesByType(Place.Type.RESTAURANT)
            "Shopping" -> presenter.getPlacesByType(Place.Type.SHOPPING)
            "Landmark" -> presenter.getPlacesByType(Place.Type.LANDMARK)
        }

        // a better way
//        if (filter == "All") {
//            presenter.getAllPlaces()
//        } else {
//            val filterE = Place.Type.valueOf(filter.toString().toUpperCase())
//            presenter.getPlacesByType(filterE)
//        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // TODO
    }

    override fun setPlaceList(places: MutableList<Place>?) {
        places?.let {
            placeAdapter.setPlaces(it)
        }
    }

    inner class PlaceAdapter(private var places: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var tvPlaceName: TextView = view.tvPlaceName
        }

        fun setPlaces(places: List<Place>) {
            this.places = places
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
            val vh = ViewHolder(v)
            return vh
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvPlaceName.text = places[position].name
        }

        override fun getItemCount() = places.size

    }


}