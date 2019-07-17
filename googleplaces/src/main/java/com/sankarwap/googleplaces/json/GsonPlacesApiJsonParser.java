package com.sankarwap.googleplaces.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sankarwap.googleplaces.model.Place;
import com.sankarwap.googleplaces.model.PlacesAutocompleteResponse;
import com.sankarwap.googleplaces.model.PlacesDetailsResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class GsonPlacesApiJsonParser implements PlacesApiJsonParser {
    private final Gson gson;

    public GsonPlacesApiJsonParser() {
        gson = new GsonBuilder()
            .create();
    }

    @Override
    public PlacesAutocompleteResponse autocompleteFromStream(final InputStream is)  throws JsonParsingException {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return gson.fromJson(reader, PlacesAutocompleteResponse.class);
        } catch (Exception e) {
            throw new JsonParsingException(e);
        }
    }

    @Override
    public PlacesDetailsResponse detailsFromStream(final InputStream is) throws JsonParsingException {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return gson.fromJson(reader, PlacesDetailsResponse.class);
        } catch (Exception e) {
            throw new JsonParsingException(e);
        }
    }

    @Override
    public List<Place> readHistoryJson(final InputStream in) throws JsonParsingException {
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
            List<Place> places = new ArrayList<>();
            reader.beginArray();
            while (reader.hasNext()) {
                Place message = gson.fromJson(reader, Place.class);
                places.add(message);
            }
            reader.endArray();
            reader.close();
            return places;
        } catch (Exception e) {
            throw new JsonParsingException(e);
        }
    }

    @Override
    public void writeHistoryJson(final OutputStream os, final List<Place> places) throws JsonWritingException {
        try {
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.setIndent("  ");
            writer.beginArray();
            for (Place place : places) {
                gson.toJson(place, Place.class, writer);
            }
            writer.endArray();
            writer.close();
        } catch (Exception e) {
            throw new JsonWritingException(e);
        }
    }
}
