package com.sankarwap.googleplaces.history;


import androidx.annotation.NonNull;
import com.sankarwap.googleplaces.model.Place;

import java.util.List;

public interface OnHistoryUpdatedListener {
    public void onHistoryUpdated(@NonNull List<Place> updatedHistory);
}
