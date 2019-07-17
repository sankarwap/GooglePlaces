package com.sankarwap.googleplaces.model;

import com.google.gson.annotations.SerializedName;

public enum PlaceType {
    @SerializedName("route")
    ROUTE,
    @SerializedName("geocode")
    GEOCODE
}
