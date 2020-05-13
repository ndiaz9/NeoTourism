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
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentIntereses extends Fragment {

    private ArrayList<Integer> mImages = new ArrayList<Integer>();
    private ArrayList<String> mPreferencias = new ArrayList<String>();
    private ArrayList<Boolean> mSelected = new ArrayList<>();

    public FragmentIntereses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_intereses, container, false);
        Spinner spinner = rootView.findViewById(R.id.spinnerIdioma);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(rootView.getContext(),R.array.idiomas_array,android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);


        getPreferencias();
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(),2);
        final RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewPref);
        recyclerView.setLayoutManager(layoutManager);
        AdapterPreferencias adapter = new AdapterPreferencias(this.getActivity(),mImages,mPreferencias);

        adapter.setOnItemClickListener(new AdapterPreferencias.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                String interes = mPreferencias.get(pos);
                if (mSelected.get(pos)) {
                    ((MainActivity)getActivity()).removeInterest(interes);
                    Toast.makeText(getContext(),"Remover: " + interes, Toast.LENGTH_LONG).show();
                    mSelected.add(pos,false);
                } else {
                    ((MainActivity)getActivity()).addInterest(interes);
                    Toast.makeText(getContext(),"Añadir: " + interes, Toast.LENGTH_LONG).show();
                    mSelected.add(pos,true);
                }
            }
        });

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

        mSelected.add(false);
        mSelected.add(false);
        mSelected.add(false);
        mSelected.add(false);
        mSelected.add(false);
        mSelected.add(false);
    }
}
