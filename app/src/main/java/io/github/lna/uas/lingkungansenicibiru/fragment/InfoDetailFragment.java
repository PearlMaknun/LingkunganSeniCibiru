package io.github.lna.uas.lingkungansenicibiru.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class InfoDetailFragment extends Fragment {

    String id = null;

    public InfoDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_detail, container, false);

        //id = getArguments().getString("id");

        //getData();

        return view;
    }

    public void getData(){
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<LingkunganSeniResponse> call = apiService.getDetail(id, API_KEY);

        call.enqueue(new Callback<LingkunganSeniResponse>() {
            @Override
            public void onResponse(Call<LingkunganSeniResponse> call, Response<LingkunganSeniResponse> response) {
                try {
                    final List<LingkunganSeni> lingkunganSenis = response.body().getData();
                    Log.d("response", response.body().toString());
                    //recyclerView.setAdapter(new LingkunganSeniAdapter(lingkunganSenis, R.layout.adapter_lingkungan_seni, getApplicationContext()));
                } catch (Exception e) {

                    Log.d("ERROR", e.getMessage());
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LingkunganSeniResponse> call, Throwable t) {

                Toast.makeText(getContext(), getString(R.string.no_internet), Toast.LENGTH_LONG).show();
            }
        });
    }

}