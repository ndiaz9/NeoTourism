package com.neotourism.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.neotourism.MainActivity;
import com.neotourism.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MiCuenta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiCuenta extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private EditText nameText;
    private EditText emailText;
    private EditText passwordText;
    private Button saveButton;
    private Button logoutButton;

    public MiCuenta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiCuenta.
     */
    // TODO: Rename and change types and number of parameters
    public static MiCuenta newInstance(String param1, String param2) {
        MiCuenta fragment = new MiCuenta();
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
        String name = ((MainActivity)getActivity()).getUserInfo().getString("name");
        String email = ((MainActivity)getActivity()).getUserInfo().getString("email");
        String password = ((MainActivity)getActivity()).getUserInfo().getString("password");

        view = inflater.inflate(R.layout.fragment_mi_cuenta, container, false);
        nameText = view.findViewById(R.id.name);
        emailText = view.findViewById(R.id.username);
        passwordText = view.findViewById(R.id.password);

        nameText.setText(name);
        emailText.setText(email);
        passwordText.setText(password);

        saveButton = view.findViewById(R.id.btnGuardar);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeName(nameText.getText().toString());
                ((MainActivity) getActivity()).changeEmail(emailText.getText().toString());
                ((MainActivity) getActivity()).changePassword(passwordText.getText().toString());
                Toast.makeText(getContext(), "Información guardada", Toast.LENGTH_LONG).show();
            }
        });

        logoutButton = view.findViewById(R.id.btnCerrar);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).logout();
            }
        });

        return view;
    }

}
