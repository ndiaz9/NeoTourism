package com.neotourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.navigation.NavigationView;
import com.neotourism.fragments.ContenedorPlacesFragment;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<Dato> favoritos;
    private List<Dato> recomendados;
    private List<Dato> cercaATi;

    private static final int CANTIDAD_LUGARES = 2;
    private LatLng latLngAct;
    private LatLng[] latLngs = {
            new LatLng(4.601639, -74.067687),
            new LatLng(4.601211, -74.069221)
    };

    private List<Dato> todos = new ArrayList<>(
            Arrays.asList(
                    new Dato(
                            "La Pola",
                            0,
                            new ArrayList<String>(
                                    Arrays.asList(
                                            "Historia",
                                            "Independencia"
                                    )
                            ),
                            R.drawable.lapolaredonda
                    ),
                    new Dato(
                            "Templete Bolívar",
                            0,
                            new ArrayList<String>(
                                    Arrays.asList(
                                            "Historia",
                                            "Independencia"
                                    )
                            ),
                            R.drawable.bolivarredondo
                    )
            )
    );

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
        favoritos = new ArrayList<>();
        recomendados = new ArrayList<>();
        cercaATi = new ArrayList<>();
        addTodos();


        if (getIntent().getExtras().containsKey(MapsActivity.EXTRA_MESSAGE)) {
            String name = getIntent().getStringExtra(MapsActivity.EXTRA_MESSAGE);
            Dato seleccionado = null;
            ArrayList<String> tagsTemp = new ArrayList<>();
            tagsTemp.add("Historia");
            tagsTemp.add("Independencia");
            if(name.equals(getString(R.string.text_lapola))) {
                favoritos.add(new Dato("La Pola", 100, tagsTemp, R.drawable.lapolaredonda));
            } else {
                favoritos.add(new Dato("Templete Bolívar", 200, tagsTemp, R.drawable.bolivarredondo));
            }

        }
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

    public List<Dato> getTodos() {return todos;}

    public void addTodos() {
        for (int i = 0; i < CANTIDAD_LUGARES; i++) {
            todos.get(i).setDistancia(calcularDistancia(latLngs[i]));
        };
    }

    public List<Dato> getRecomendados() {return recomendados;}

    public List<Dato> getCercaATi() {return cercaATi;}

    public List<Dato> getFavoritos() {return favoritos;}

    public void addFavorito(Dato place) {favoritos.add(place);}

    public void removeFavorito(Dato place) {favoritos.remove(place);}

    public List<String> getInterests() {return interests;}

    public void addInterest(String interest) {
        interests.add(interest);
        for (Dato place: todos) {
            for (String tag: place.getTags()) {
                if (tag.equals(interest)) {
                    recomendados.add(place);
                    break;
                }
            }
        }
    }

    public void removeInterest(String interest) {
        interests.remove(interest);
        for (Dato place: recomendados) {
            boolean remove = true;
            for (String tag: place.getTags()) {
                for (String interes: interests) {
                    if(tag.equals(interes)) {
                        remove = false;
                        break;
                    }
                }
                if (!remove) break;
            }
            if (remove) recomendados.remove(place);
        }
    }

    public void logout() {
        Intent intent = new Intent(this, IngresarActivity.class);
        startActivity(intent);
    }

    private int calcularDistancia(LatLng latLng) {
        return 100;
    }
}
