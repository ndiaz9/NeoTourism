package com.neotourism.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.neotourism.AdapterDatos;
import com.neotourism.Dato;
import com.neotourism.MainActivity;
import com.neotourism.MapsActivity;
import com.neotourism.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Todos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerPlaces;

    List<Dato> listaPlaces;

    public Todos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Todos.
     */
    // TODO: Rename and change types and number of parameters
    public static Todos newInstance(String param1, String param2) {
        Todos fragment = new Todos();
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
        View vista= inflater.inflate(R.layout.fragment_todos, container, false);

        buildRecycler(vista);

        return vista;
    }

    private void llenarLista() {
        //TODO please llena esto con los datos manuales
        listaPlaces = ((MainActivity)getActivity()).getTodos();
    }

    private void buildRecycler(View vista) {
        recyclerPlaces = (RecyclerView) vista.findViewById(R.id.todosView);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(getContext()));
        listaPlaces = new ArrayList<Dato>();

        llenarLista();

        AdapterDatos adapter = new AdapterDatos(listaPlaces);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = listaPlaces.get(recyclerPlaces.getChildAdapterPosition(view)).getNombre();

                Intent intent = new Intent(getContext(), MapsActivity.class);
                Bundle b = ((MainActivity)getActivity()).getUserInfo();
                b.putString(getString(R.string.arg_show_place), nombre);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        recyclerPlaces.setAdapter(adapter);
    }
}
