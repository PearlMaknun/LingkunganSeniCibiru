package io.github.lna.uas.lingkungansenicibiru.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.adapter.SectionPageAdapter;

public class BerandaFragment extends Fragment {

    private SectionPageAdapter sectionPageAdapter;
    ViewPager viewpager;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_beranda, container, false);

        sectionPageAdapter = new SectionPageAdapter(getActivity().getSupportFragmentManager());
        viewpager = view.findViewById(R.id.viewpager);
        setupViewPager(viewpager);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getActivity().getSupportFragmentManager());
        String tab1 = String.format(getResources().getString(R.string.discover));
        String tab2 = String.format(getResources().getString(R.string.kelurahan));
        String tab3 = String.format(getResources().getString(R.string.jeniskesenian));
        adapter.addFragment(new DiscoverFragment(), tab1);
        adapter.addFragment(new KelurahanFragment(), tab2);
        adapter.addFragment(new JenisKesenianFragment(), tab3);
        viewPager.setAdapter(adapter);
    }
}
