package com.placeslibraryown
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sankarwap.googleplaces.DetailsCallback
import com.sankarwap.googleplaces.GooglePlacesAuto
import com.sankarwap.googleplaces.model.PlaceDetails

class MainActivity : AppCompatActivity() {
    internal lateinit var mAutocomplete: GooglePlacesAuto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAutocomplete = findViewById(R.id.autocomplete)
        mAutocomplete.setOnPlaceSelectedListener { place ->
            mAutocomplete.getDetailsFor(place, object : DetailsCallback {
                override fun onSuccess(details: PlaceDetails) {
                    hideKeyboard()
                    Log.d("place", "address " + details.formatted_address)
                    Log.d("place", "lat " + details.geometry.location.lat)
                    Log.d("place", "lng " + details.geometry.location.lng)
                    Toast.makeText(this@MainActivity, details.formatted_address, Toast.LENGTH_SHORT)
                        .show()
                }
                override fun onFailure(failure: Throwable) {
                    Log.d("test", "failure $failure")
                }
            })
        }
    }

    fun hideKeyboard() {
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = this.currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
