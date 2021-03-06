package io.github.lna.uas.lingkungansenicibiru.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.adapter.LingkunganSeniAdapter;
import io.github.lna.uas.lingkungansenicibiru.api.ApiClient;
import io.github.lna.uas.lingkungansenicibiru.api.ApiService;
import io.github.lna.uas.lingkungansenicibiru.model.LingkunganSeni;
import io.github.lna.uas.lingkungansenicibiru.model.LingkunganSeniResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static io.github.lna.uas.lingkungansenicibiru.BuildConfig.API_KEY;

public class ResultbyKelurahan extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView result, district;
    String id = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultby_kelurahan);

        id = getIntent().getStringExtra("id");
        district = findViewById(R.id.district_name);
        result = findViewById(R.id.result);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        district.setText(getIntent().getStringExtra("kelurahan"));
        getData();
    }

    public void getData() {

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<LingkunganSeniResponse> call = apiService.getLingSenibyKelurahan(id, API_KEY);

        call.enqueue(new Callback<LingkunganSeniResponse>() {
            @Override
            public void onResponse(Call<LingkunganSeniResponse> call, Response<LingkunganSeniResponse> response) {
                try {
                    final List<LingkunganSeni> lingkunganSenis = response.body().getData();
                    Log.d("response", response.body().toString());
                    recyclerView.setAdapter(new LingkunganSeniAdapter(lingkunganSenis, R.layout.adapter_lingkungan_seni, getApplicationContext()));
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
