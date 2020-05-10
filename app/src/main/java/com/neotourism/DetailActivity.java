package com.neotourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.neotourism.ui.AdapterComments;
import com.neotourism.ui.AdapterImages;
import com.unity3d.player.UnityPlayerActivity;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView descripcion;
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<Integer> mImagesUsers = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mComments = new ArrayList<>();
    private ImageButton favButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        titulo = findViewById(R.id.textLugar);
        descripcion = findViewById(R.id.textDescripcion);
        favButton = findViewById(R.id.favButton);
        favButton.setTag(new Integer(0));
        String currentText = getIntent().getStringExtra(MapsActivity.EXTRA_MESSAGE);
        setResources(currentText);
        getImages(currentText);
        getComments();
        initRecyclerView();
        initRecyclerViewComments();
    }

    public void onClickAR(View view){
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }

    public void onClickFav(View view){
        Integer currentState = (Integer) favButton.getTag();
        if(currentState == 0){
            favButton.setTag(new Integer(1));
            favButton.setBackgroundResource(R.drawable.ic_star_black_24dp);
        }
        else{
            favButton.setTag(new Integer(0));
            favButton.setBackgroundResource(R.drawable.ic_star_border_black_24dp);
        }
    }

    public void setResources(String currentText){
        if(currentText.equals(getString(R.string.text_lapola))){
            titulo.setText(R.string.text_lapola);
            descripcion.setText(R.string.desc_lapola);
        }
        else if(currentText.equals(getString(R.string.text_bolivar))){
            titulo.setText(R.string.text_bolivar);
            descripcion.setText(R.string.desc_bolivar);
        }
    }
    public void getImages(String currentText){
        if(currentText.equals(getString(R.string.text_lapola))){
            mImages.add(R.drawable.lapola1mini);
            mImages.add(R.drawable.lapola2mini);
            mImages.add(R.drawable.lapola3mini);
            mImages.add(R.drawable.lapola4mini);
        }
        else if(currentText.equals(getString(R.string.text_bolivar))){
            mImages.add(R.drawable.bolivar1);
            mImages.add(R.drawable.bolivar2);
            mImages.add(R.drawable.bolivar3);
            mImages.add(R.drawable.bolivar4);
        }
    }
    public void getComments(){
        mImagesUsers.add(R.drawable.lapola1mini);
        mImagesUsers.add(R.drawable.lapola2mini);
        mImagesUsers.add(R.drawable.lapola3mini);
        mImagesUsers.add(R.drawable.lapola4mini);
        mImagesUsers.add(R.drawable.lapola1mini);
        mImagesUsers.add(R.drawable.lapola2mini);
        mImagesUsers.add(R.drawable.lapola3mini);
        mImagesUsers.add(R.drawable.lapola4mini);

        mNames.add("Roberto Séneca");
        mNames.add("Adriana Quijano");
        mNames.add("Federico López");
        mNames.add("Ana María Forero");
        mNames.add("Roberto Séneca");
        mNames.add("Adriana Quijano");
        mNames.add("Federico López");
        mNames.add("Ana María Forero");

        mComments.add("Me gusta mucho este lugar.");
        mComments.add("Perfecto para pasar la tarde.");
        mComments.add("Me encanta el ambiente.");
        mComments.add("Muy bonito.");
        mComments.add("Me gusta mucho este lugar.");
        mComments.add("Perfecto para pasar la tarde.");
        mComments.add("Me encanta el ambiente.");
        mComments.add("Muy bonito.");
    }
    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        AdapterImages adapter = new AdapterImages(this,mImages);
        SnapHelper helper = new LinearSnapHelper();
        recyclerView.setAdapter(adapter);
        helper.attachToRecyclerView(recyclerView);
    }
    private void initRecyclerViewComments(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewComm);
        recyclerView.setLayoutManager(layoutManager);
        AdapterComments adapter = new AdapterComments(this,mImagesUsers,mNames,mComments);
        recyclerView.setAdapter(adapter);
    }
}
