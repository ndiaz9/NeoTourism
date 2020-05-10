package com.neotourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unity3d.player.BuildConfig;
import com.unity3d.player.UnityPlayerActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView descripcion;
    private ImageView imgDetail1;
    private ImageView imgDetail2;
    private ImageView imgDetail3;
    private ImageView imgDetail4;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        titulo = findViewById(R.id.textLugar);
        descripcion = findViewById(R.id.textDescripcion);
        imgDetail1 = findViewById(R.id.imageDetail1);
        imgDetail2 = findViewById(R.id.imageDetail2);
        imgDetail3 = findViewById(R.id.imageDetail3);
        imgDetail4 = findViewById(R.id.imageDetail4);
        linearLayout = findViewById(R.id.linearLayout);

        int width = getScreenWidth(DetailActivity.this);
        int childCount=linearLayout.getChildCount();
        for (int i=0;i<childCount;i++){
            ImageView imageView= (ImageView) linearLayout.getChildAt(i);
            imageView.setMinimumWidth(width);
            imageView.setMaxWidth(width);
        }

        String currentText = getIntent().getStringExtra(MapsActivity.EXTRA_MESSAGE);
        setResources(currentText);
    }

    public void onClickAR(View view){
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }

    public void setResources(String currentText){
        if(currentText.equals(getString(R.string.text_lapola))){
            titulo.setText(R.string.text_lapola);
            descripcion.setText(R.string.desc_lapola);
            imgDetail1.setImageResource(R.drawable.lapola1mini);
            imgDetail2.setImageResource(R.drawable.lapola2mini);
            imgDetail3.setImageResource(R.drawable.lapola3mini);
            imgDetail4.setImageResource(R.drawable.lapola4mini);
        }
    }
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
