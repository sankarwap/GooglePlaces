package com.sankarwap.googleplaces.network;

import android.net.Uri;
import com.sankarwap.googleplaces.model.PlacesAutocompleteResponse;
import com.sankarwap.googleplaces.model.PlacesDetailsResponse;

import java.io.IOException;

public interface PlacesHttpClient {
    PlacesAutocompleteResponse executeAutocompleteRequest(Uri uri) throws IOException;

    PlacesDetailsResponse executeDetailsRequest(Uri uri) throws IOException;
}
