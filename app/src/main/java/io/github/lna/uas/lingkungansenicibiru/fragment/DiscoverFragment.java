package io.github.lna.uas.lingkungansenicibiru.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.lna.uas.lingkungansenicibiru.BuildConfig;
import io.github.lna.uas.lingkungansenicibiru.R;

public class DiscoverFragment extends Fragment {

    private final static String API_KEY = BuildConfig.API_KEY;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;

    public DiscoverFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        //getData();

        return view;
    }
}
