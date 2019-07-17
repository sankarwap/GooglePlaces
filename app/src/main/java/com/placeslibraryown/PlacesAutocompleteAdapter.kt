package com.placeslibraryown

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sankarwap.googleplaces.PlacesApi
import com.sankarwap.googleplaces.adapter.AbstractPlacesAutocompleteAdapter
import com.sankarwap.googleplaces.history.AutocompleteHistoryManager
import com.sankarwap.googleplaces.model.AutocompleteResultType
import com.sankarwap.googleplaces.model.Place

class PlacesAutocompleteAdapter(
    context: Context,
    api: PlacesApi,
    resultType: AutocompleteResultType,
    history: AutocompleteHistoryManager
) : AbstractPlacesAutocompleteAdapter(context, api, resultType, history) {

    override fun newView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.places_autocomplete_item, parent, false)
    }

    override fun bindView(view: View, item: Place) {
        (view as TextView).text = item.description
    }
}
