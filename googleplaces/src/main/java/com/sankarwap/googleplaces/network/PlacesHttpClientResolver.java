package com.sankarwap.googleplaces.network;

import com.sankarwap.googleplaces.json.JsonParserResolver;
import com.sankarwap.googleplaces.json.PlacesApiJsonParser;

public final class PlacesHttpClientResolver {
    public static final PlacesHttpClient PLACES_HTTP_CLIENT;

    static {
        boolean hasOkHttp;

        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            hasOkHttp = true;
        } catch (ClassNotFoundException e) {
            hasOkHttp = false;
        }

        PlacesApiJsonParser parser = JsonParserResolver.JSON_PARSER;

        PLACES_HTTP_CLIENT = hasOkHttp ? new OkHttpPlacesHttpClient(parser) : new HttpUrlConnectionMapsHttpClient(parser);
    }

    private PlacesHttpClientResolver() {
        throw new RuntimeException("No Instances!");
    }
}
