package io.github.lna.uas.lingkungansenicibiru.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.lna.uas.lingkungansenicibiru.R;

public class JenisKesenianFragment extends Fragment {

    public JenisKesenianFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jenis_kesenian, container, false);
    }
}
