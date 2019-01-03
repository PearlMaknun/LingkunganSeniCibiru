package io.github.lna.uas.lingkungansenicibiru.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.adapter.SectionPageAdapter;
import io.github.lna.uas.lingkungansenicibiru.fragment.AboutFragment;
import io.github.lna.uas.lingkungansenicibiru.fragment.BerandaFragment;
import io.github.lna.uas.lingkungansenicibiru.fragment.DiscoverFragment;
import io.github.lna.uas.lingkungansenicibiru.fragment.JenisKesenianFragment;
import io.github.lna.uas.lingkungansenicibiru.fragment.KelurahanFragment;

public class Beranda extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private SectionPageAdapter sectionPageAdapter;
    ViewPager viewpager;*/

    //baru
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        viewpager = findViewById(R.id.viewpager);
        setupViewPager(viewpager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            fragment = new BerandaFragment();
            callFragment(fragment);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        String tab1 = String.format(getResources().getString(R.string.discover));
        String tab2 = String.format(getResources().getString(R.string.kelurahan));
        String tab3 = String.format(getResources().getString(R.string.jeniskesenian));
        adapter.addFragment(new DiscoverFragment(), tab1);
        adapter.addFragment(new KelurahanFragment(), tab2);
        adapter.addFragment(new JenisKesenianFragment(), tab3);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.beranda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new BerandaFragment();
            callFragment(fragment);
        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_about) {
            fragment = new AboutFragment();
            callFragment(fragment);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rateus) {

        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void callFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

}
