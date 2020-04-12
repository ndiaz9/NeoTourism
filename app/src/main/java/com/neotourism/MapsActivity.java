package com.neotourism;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mLapola;
    private Button butobservar;
    private ImageView imgLapola;
    private TextView txtLapola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        butobservar = (Button) findViewById(R.id.buttonObservar);
        imgLapola = (ImageView) findViewById(R.id.imageView1);
        txtLapola = (TextView) findViewById(R.id.textView1);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng lapola = new LatLng(4.601639, -74.067687);
        mLapola = mMap.addMarker(new MarkerOptions().position(lapola).title("Monumento La Pola"));
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lapola,16));
    }
    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        if(imgLapola.getVisibility() == View.VISIBLE){
            butobservar.setVisibility(View.INVISIBLE);
            imgLapola.setVisibility(View.INVISIBLE);
            txtLapola.setVisibility(View.INVISIBLE);
        }else{
            butobservar.setVisibility(View.VISIBLE);
            imgLapola.setVisibility(View.VISIBLE);
            txtLapola.setVisibility(View.VISIBLE);
        }
        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    public void onClickObservar(View view){
        Toast.makeText(this, "I've been summoned.", Toast.LENGTH_SHORT).show();
    }
}
