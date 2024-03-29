package com.sankarwap.googleplaces.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sankarwap.googleplaces.PlacesApi;
import com.sankarwap.googleplaces.R;
import com.sankarwap.googleplaces.history.AutocompleteHistoryManager;
import com.sankarwap.googleplaces.model.AutocompleteResultType;
import com.sankarwap.googleplaces.model.Place;

public class DefaultAutocompleteAdapter extends AbstractPlacesAutocompleteAdapter {

    public DefaultAutocompleteAdapter(final Context context, final PlacesApi api, final AutocompleteResultType autocompleteResultType, final AutocompleteHistoryManager history) {
        super(context, api, autocompleteResultType, history);
    }

    @Override
    protected View newView(final ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.pacv_maps_autocomplete_item, parent, false);
    }

    @Override
    protected void bindView(final View view, final Place item) {
        ((TextView)view).setText(item.description);
    }
}
