package com.neotourism.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.neotourism.AdapterTabs;
import com.neotourism.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContenedorPlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContenedorPlacesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    public ContenedorPlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContenedorPlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContenedorPlacesFragment newInstance(String param1, String param2) {
        ContenedorPlacesFragment fragment = new ContenedorPlacesFragment();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contenedor_places, container, false);
    }

    //@Override
    //public void onViewCreated(View view, Bundle savedInstanceState) {
    //    TabLayout tabLayout = view.findViewById(R.id.);
    //  tabLayout.setupWithViewPager(viewPager);
    //}


    private void fillViewPager(ViewPager viewPager) {
        AdapterTabs adapter = new AdapterTabs(getFragmentManager());
        adapter.addFragment(new ListaCercaATi(), "Cerca a ti");
        adapter.addFragment(new Recomendados(), "Recomendados");

        viewPager.setAdapter(adapter);
    }
}
