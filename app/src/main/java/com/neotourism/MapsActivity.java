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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    public static final String EXTRA_MESSAGE = "com.neotourism.MESSAGE";

    private GoogleMap mMap;
    private Marker mLapola;
    private Marker mBolivar;
    private Button butobservar;
    private ImageView img;
    private TextView txt;
    private String currentMarker;

    private LatLng[] latLngs = {
            new LatLng(4.598413,-74.077561),
            new LatLng(4.602199,-74.072487),
            new LatLng(4.5939915,-74.07687250000001),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.597122000000001,-74.0728355),
            new LatLng(4.595503,-74.0724455),
            new LatLng(4.611139,-74.068494),
            new LatLng(4.59889, -74.08083),
            new LatLng(41.58333,13.58333),
            new LatLng(4.668644,4.668644),
            new LatLng(4.5951725,-74.075551),
            new LatLng(4.595847,-74.0739655),
            new LatLng(4.684065,-74.146297),
            new LatLng(4.597122000000001,-74.0728355),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.716566,-74.097252),
            new LatLng(4.5980419999999995,-74.0754305),
            new LatLng(4.597697999999999,-74.074152),
            new LatLng(4.59889, -74.08083),
            new LatLng(4.5952485,-74.0785),
            new LatLng(4.60051075,-74.07354825),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.5967135,-74.07578425),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.596319,-74.073418),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.658497,-74.057319),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.596334,-74.073042),
            new LatLng(4.59889, -74.08083),
            new LatLng(4.600268,-74.075889),
            new LatLng(4.59889,-74.08083),
            new LatLng(4.59889, -74.08083),
            new LatLng(3.81667, -73.91667),
            new LatLng(4.596748,-74.07465),
            new LatLng(4.597977,-74.074878),
            new LatLng(3.81667,-73.91667),
            new LatLng(4.594884,-74.0762015),
            new LatLng(4.597626,-74.075712),
            new LatLng(4.595847,-74.0739655),
            new LatLng(4.5952485,-74.0785),
            new LatLng(4.596358,-74.075184),
            new LatLng(4.596319,-74.073418),
            new LatLng(4.595778,-74.072929),
            new LatLng(4.59889, -74.08083)
    };


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

        mMap.setOnMarkerClickListener(this);

        if (getIntent().getExtras().containsKey(getString(R.string.arg_show_place))) {
            String name = getIntent().getStringExtra(getString(R.string.arg_show_place));

            if(name.equals(getString(R.string.text_lapola))) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lapola,16));
                mLapola = mMap.addMarker(new MarkerOptions().position(lapola).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).title(getString(R.string.text_lapola)));
                mBolivar = mMap.addMarker(new MarkerOptions().position(bolivar).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).title(getString(R.string.text_bolivar)));
                mLapola.setTag("Pola");
                mBolivar.setTag("Bolivar");
                onMarkerClick(mLapola);
            } else if (name.equals(getString(R.string.text_bolivar))) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bolivar,16));
                mLapola = mMap.addMarker(new MarkerOptions().position(lapola).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).title(getString(R.string.text_lapola)));
                mBolivar = mMap.addMarker(new MarkerOptions().position(bolivar).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).title(getString(R.string.text_bolivar)));
                mLapola.setTag("Pola");
                mBolivar.setTag("Bolivar");
                onMarkerClick(mBolivar);
            }
        } else {
            mLapola = mMap.addMarker(new MarkerOptions().position(lapola).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).title(getString(R.string.text_lapola)));
            mBolivar = mMap.addMarker(new MarkerOptions().position(bolivar).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).title(getString(R.string.text_bolivar)));
            mLapola.setTag("Pola");
            mBolivar.setTag("Bolivar");
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lapola,16));
        }

        for (int i = 0; i < latLngs.length; i++) {
            mMap.addMarker(new MarkerOptions().position(latLngs[i]).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).title(getString(R.string.text_bolivar)));
        }

    }
    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        if (marker.getTag() != null) {
            if (marker.getTag().toString().equals(currentMarker)) {
                switchVisibility();
            } else {
                setResources(marker);
                butobservar.setVisibility(View.VISIBLE);
                img.setVisibility(View.VISIBLE);
                txt.setVisibility(View.VISIBLE);
            }
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
        Bundle b = getIntent().getExtras();
        b.putString(EXTRA_MESSAGE,currentText);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void onClickMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
    }
}
