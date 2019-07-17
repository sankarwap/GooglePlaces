package com.sankarwap.googleplaces.network;

import android.net.Uri;
import com.sankarwap.googleplaces.json.JsonParsingException;
import com.sankarwap.googleplaces.json.PlacesApiJsonParser;
import com.sankarwap.googleplaces.model.PlacesApiResponse;
import com.sankarwap.googleplaces.model.PlacesAutocompleteResponse;
import com.sankarwap.googleplaces.model.PlacesDetailsResponse;

import java.io.IOException;
import java.io.InputStream;

abstract class AbstractPlacesHttpClient implements PlacesHttpClient {

    protected final PlacesApiJsonParser placesApiJsonParser;

    protected AbstractPlacesHttpClient(PlacesApiJsonParser parser) {
        placesApiJsonParser = parser;
    }

    @Override
    public PlacesAutocompleteResponse executeAutocompleteRequest(final Uri uri) throws IOException {
        return executeNetworkRequest(uri, new ResponseHandler<PlacesAutocompleteResponse>() {

            @Override
            public PlacesAutocompleteResponse handleStreamResult(final InputStream is) throws JsonParsingException {
                return placesApiJsonParser.autocompleteFromStream(is);
            }
        });
    }

    @Override
    public PlacesDetailsResponse executeDetailsRequest(final Uri uri) throws IOException {
        return executeNetworkRequest(uri, new ResponseHandler<PlacesDetailsResponse>() {

            @Override
            public PlacesDetailsResponse handleStreamResult(final InputStream is) throws JsonParsingException {
                return placesApiJsonParser.detailsFromStream(is);
            }
        });
    }

    protected abstract <T extends PlacesApiResponse> T executeNetworkRequest(Uri uri, ResponseHandler<T> responseHandler) throws IOException;
}
