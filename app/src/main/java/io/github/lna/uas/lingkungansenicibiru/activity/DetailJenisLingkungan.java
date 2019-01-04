package io.github.lna.uas.lingkungansenicibiru.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.adapter.SectionPageAdapter;
import io.github.lna.uas.lingkungansenicibiru.fragment.InfoDetailFragment;
import io.github.lna.uas.lingkungansenicibiru.fragment.ReviewDetailFragment;

public class DetailJenisLingkungan extends AppCompatActivity {

    private SectionPageAdapter sectionPageAdapter;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_lingkungan_seni);

        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        viewpager = findViewById(R.id.viewpager);
        setupViewPager(viewpager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        String tab1 = String.format(getResources().getString(R.string.info));
        String tab2 = String.format(getResources().getString(R.string.review));
        adapter.addFragment(new InfoDetailFragment(), tab1);
        adapter.addFragment(new ReviewDetailFragment(), tab2);
        viewPager.setAdapter(adapter);
    }
}
