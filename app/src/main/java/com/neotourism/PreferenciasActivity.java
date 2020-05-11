package com.neotourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class PreferenciasActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentIntereses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        Spinner spinner = findViewById(R.id.spinnerIdioma);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.idiomas_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        fragmentIntereses = new FragmentIntereses();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorPref,fragmentIntereses).commit();

    }
}
