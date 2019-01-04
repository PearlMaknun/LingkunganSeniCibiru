package io.github.lna.uas.lingkungansenicibiru.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.api.ApiClient;
import io.github.lna.uas.lingkungansenicibiru.api.ApiService;
import io.github.lna.uas.lingkungansenicibiru.model.LingkunganSeni;
import io.github.lna.uas.lingkungansenicibiru.model.LingkunganSeniResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static io.github.lna.uas.lingkungansenicibiru.BuildConfig.API_KEY;

public class DetailCadangan extends AppCompatActivity {

    String id = null;
    String location = null;
    TextView nama, jeniskesenian, tahun, pemimpin, alamat, deskripsi, _long, lat;
    ImageView imageView;
    List<LingkunganSeni> lingkunganSenis;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cadangan);

        id = getIntent().getStringExtra("id");
        nama = findViewById(R.id.nama_lingkungan);
        pemimpin = findViewById(R.id.pemimpin);
        jeniskesenian = findViewById(R.id.jenis_kesenian);
        tahun = findViewById(R.id.tahun_kesenian);
        pemimpin = findViewById(R.id.pemimpin);
        alamat = findViewById(R.id.nama_lokasi);
        imageView = findViewById(R.id.detail_image_jk);
        deskripsi = findViewById(R.id.isi_deskripsi);
        cardView = findViewById(R.id.btn_lokasi);

        //getData();
        /*
                i.putExtra("id", id);
                i.putExtra("nama", nama);
                i.putExtra("alamat", alamat);
                i.putExtra("deskripsi", deskripsi);
                i.putExtra("kelurahan", kelurahan);
                i.putExtra("foto", foto);
                i.putExtra("lat", lat);
                i.putExtra("long", longtitude);
                i.putExtra("pimpinan", pimpinan);
                i.putExtra("jeniskesenian", jeniskesenian);
                i.putExtra("tahun", tahun);
         */

        nama.setText(getIntent().getStringExtra("nama"));
        alamat.setText(getIntent().getStringExtra("alamat"));
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
        //nama.setText(getIntent().getStringExtra("kelurahan"));
        if(getIntent().getStringExtra("foto").length() == 0){
            Glide.with(getApplicationContext())
                    .load(R.drawable.pict_teras)
                    .into(imageView);
        }else{
            Glide.with(getApplicationContext())
                    .load(getIntent().getStringExtra("foto"))
                    .into(imageView);
        }
        Glide.with(getApplicationContext())
                .load(R.drawable.pict_teras)
                .into(imageView);
        //nama.setText(getIntent().getStringExtra("lat"));
        //nama.setText(getIntent().getStringExtra("long"));
        if(getIntent().getStringExtra("lat") == ""){
            Toast.makeText(getApplicationContext(), "Belum disematkan loakasi", Toast.LENGTH_LONG).show();
        }else{
            location = getIntent().getStringExtra("lat") + "," + getIntent().getStringExtra("long");
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                }
            });
        }


        pemimpin.setText(getIntent().getStringExtra("pimpinan"));
        tahun.setText(getIntent().getStringExtra("tahun"));
        jeniskesenian.setText(getIntent().getStringExtra("jeniskesenian"));

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }*/
                Toast.makeText(getApplicationContext(), location, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getData(){
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<LingkunganSeniResponse> call = apiService.getDetail(id, API_KEY);

        call.enqueue(new Callback<LingkunganSeniResponse>() {
            @Override
            public void onResponse(Call<LingkunganSeniResponse> call, Response<LingkunganSeniResponse> response) {
                try {
                    lingkunganSenis = response.body().getData();
                    Log.d("response", response.body().toString());
                    //recyclerView.setAdapter(new LingkunganSeniAdapter(lingkunganSenis, R.layout.adapter_lingkungan_seni, getApplicationContext()));
                } catch (Exception e) {

                    Log.d("ERROR", e.getMessage());
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LingkunganSeniResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(), getString(R.string.no_internet), Toast.LENGTH_LONG).show();
            }
        });
    }
}
