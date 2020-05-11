package com.neotourism;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    public static final String EXTRA_MESSAGE = "com.neotourism.MESSAGE";

    private GoogleMap mMap;
    private Marker mLapola;
    private Marker mBolivar;
    private Button butobservar;
    private ImageView img;
    private TextView txt;
    private String currentMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        butobservar = (Button) findViewById(R.id.buttonObservar);
        img = (ImageView) findViewById(R.id.mainImage);
        txt = (TextView) findViewById(R.id.textView1);
        currentMarker = "";
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
        LatLng bolivar = new LatLng(4.601211, -74.069221);
        mLapola = mMap.addMarker(new MarkerOptions().position(lapola).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mBolivar = mMap.addMarker(new MarkerOptions().position(bolivar).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mLapola.setTag("Pola");
        mBolivar.setTag("Bolivar");
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lapola,16));
    }
    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        if(marker.getTag().toString().equals(currentMarker)){
            switchVisibility();
        }
        else{
            setResources(marker);
            butobservar.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
            txt.setVisibility(View.VISIBLE);
        }
        currentMarker = marker.getTag().toString();
        return false;
    }

    public void setResources(Marker marker){
        String tag = (String) marker.getTag();
        if (tag.equals("Pola")){
            img.setImageResource(R.drawable.lapola);
            txt.setText(getString(R.string.text_lapola));
        }
        else if(tag.equals("Bolivar")){
            img.setImageResource(R.drawable.templetebolivar);
            txt.setText(getString(R.string.text_bolivar));
        }
    }

    public void switchVisibility(){
        if(img.getVisibility() == View.VISIBLE){
            butobservar.setVisibility(View.INVISIBLE);
            img.setVisibility(View.INVISIBLE);
            txt.setVisibility(View.INVISIBLE);
        }else{
            butobservar.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
            txt.setVisibility(View.VISIBLE);
        }
    }

    public void onClickMasInfo(View view){
        Intent intent = new Intent(this, DetailActivity.class);
        String currentText = txt.getText().toString();
        System.out.println(currentText);
        intent.putExtra(EXTRA_MESSAGE,currentText);
        startActivity(intent);
    }

    public void onClickMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
