package com.neotourism.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neotourism.AdapterDatos;
import com.neotourism.Dato;
import com.neotourism.MainActivity;
import com.neotourism.MapsActivity;
import com.neotourism.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaCercaATi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaCercaATi extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerPlaces;

    List<Dato> listaPlaces;

    public ListaCercaATi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaCercaATi.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaCercaATi newInstance(String param1, String param2) {
        ListaCercaATi fragment = new ListaCercaATi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_lista_cerca_a_ti, container, false);
        buildRecycler(vista);

        TextView noHay = vista.findViewById(R.id.textNoPlaces);
        if (listaPlaces.isEmpty()) {
            noHay.setVisibility(View.VISIBLE);
        } else {
            noHay.setVisibility(View.GONE);
        }

        return vista;
    }

    private void llenarLista() {
        //TODO please llena esto con los datos manuales
        listaPlaces = ((MainActivity) getActivity()).getCercaATi();
    }

    private void buildRecycler(View vista) {
        recyclerPlaces = (RecyclerView) vista.findViewById(R.id.cercaATiView);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(getContext()));
        listaPlaces = new ArrayList<Dato>();

        llenarLista();

        AdapterDatos adapter = new AdapterDatos(listaPlaces);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtras(((MainActivity)getActivity()).getUserInfo());
                startActivity(intent);
            }
        });

        recyclerPlaces.setAdapter(adapter);
    }
}
