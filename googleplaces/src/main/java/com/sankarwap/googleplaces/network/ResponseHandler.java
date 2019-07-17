package com.sankarwap.googleplaces.network;


import com.sankarwap.googleplaces.json.JsonParsingException;

import java.io.InputStream;

interface ResponseHandler<T> {
    T handleStreamResult(InputStream is) throws JsonParsingException, JsonParsingException;
}
