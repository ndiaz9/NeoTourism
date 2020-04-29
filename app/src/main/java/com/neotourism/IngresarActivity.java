package com.neotourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IngresarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        Button boton = (Button) findViewById(R.id.btnIniciar);
    }

    public void onClick(View v)
    {
        if (ContextCompat.checkSelfPermission(IngresarActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // No explanation needed; request the permission
            ActivityCompat.requestPermissions(IngresarActivity.this, new String[]{Manifest.permission.CAMERA},1);
        }else {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, MapsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(IngresarActivity.this, "Permiso denegado para Cámara", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}