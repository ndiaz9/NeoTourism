package com.neotourism;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView logo = (ImageView) findViewById(R.id.imageSignUp);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText email = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);



        Button boton = (Button) findViewById(R.id.SignUpRegistro);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(Registro.this, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", name.getText().toString());
                bundle.putString("email", email.getText().toString());
                bundle.putString("password", password.getText().toString());
                map.putExtras(bundle);
                startActivity(map);
            }
        });
    }



}
