package com.neotourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.neotourism.fragments.ContenedorPlacesFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Bundle userInfo;
    private List<String> interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cerca_a_ti, R.id.nav_otrosLugares, R.id.nav_favoritos, R.id.nav_preferencias, R.id.nav_mi_cuenta)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        //get user info

        userInfo = getIntent().getExtras();

        // set username
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_header_name);
        navUsername.setText(userInfo.getString("name"));

        // inicialize lists
        interests = new ArrayList<>();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public Bundle getUserInfo() {
        return userInfo;
    }

    public void changeName(String name) {
        userInfo.putString("name", name);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_header_name);
        navUsername.setText(userInfo.getString("name"));

    }

    public void changeEmail(String email) {
        userInfo.putString("email", email);
    }

    public void changePassword(String password) {
        userInfo.putString("password", password);
    }

    public void addInterest(String interest) {

    }

    public void logout() {
        Intent intent = new Intent(this, IngresarActivity.class);
        startActivity(intent);
    }
}
