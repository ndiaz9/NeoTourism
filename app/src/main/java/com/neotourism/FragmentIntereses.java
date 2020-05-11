package com.neotourism;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentIntereses extends Fragment {

    private ArrayList<Integer> mImages = new ArrayList<Integer>();
    private ArrayList<String> mPreferencias = new ArrayList<String>();

    public FragmentIntereses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_intereses, container, false);
        getPreferencias();
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(),2);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewPref);
        recyclerView.setLayoutManager(layoutManager);
        AdapterPreferencias adapter = new AdapterPreferencias(this.getActivity(),mImages,mPreferencias);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
    private void getPreferencias(){
        mImages.add(R.drawable.adventure_icon);
        mImages.add(R.drawable.art_icon);
        mImages.add(R.drawable.history_icon);
        mImages.add(R.drawable.independence_icon);
        mImages.add(R.drawable.modern_icon);
        mImages.add(R.drawable.religion_icon);

        mPreferencias.add("Aventura");
        mPreferencias.add("Arte");
        mPreferencias.add("Historia");
        mPreferencias.add("Independencia");
        mPreferencias.add("Modernidad");
        mPreferencias.add("Religión");
    }
}
