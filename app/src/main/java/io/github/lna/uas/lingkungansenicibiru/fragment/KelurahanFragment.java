package io.github.lna.uas.lingkungansenicibiru.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.BuildConfig;
import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.adapter.KelurahanAdapter;
import io.github.lna.uas.lingkungansenicibiru.api.ApiClient;
import io.github.lna.uas.lingkungansenicibiru.api.ApiService;
import io.github.lna.uas.lingkungansenicibiru.model.Kelurahan;
import io.github.lna.uas.lingkungansenicibiru.model.KelurahanResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelurahanFragment extends Fragment {

    private final static String API_KEY = BuildConfig.API_KEY;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;

    public KelurahanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kelurahan, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getData();

        return view;
    }

    public void getData() {

        String message = getString(R.string.loading);
        progressDialog = ProgressDialog.show(getContext(), null, message, true, false);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<KelurahanResponse> call = apiService.getKelurahan(API_KEY);

        call.enqueue(new Callback<KelurahanResponse>() {
            @Override
            public void onResponse(Call<KelurahanResponse> call, Response<KelurahanResponse> response) {
                try {
                    progressDialog.dismiss();
                    final List<Kelurahan> kelurahans = response.body().getData();
                    Log.d("response", response.body().toString());
                    recyclerView.setAdapter(new KelurahanAdapter(kelurahans, R.layout.adapter_list, getContext()));
                } catch (Exception e) {
                    progressDialog.dismiss();
                    Log.d("ERROR", e.getMessage());
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<KelurahanResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), getString(R.string.no_internet), Toast.LENGTH_LONG).show();
            }
        });
    }
}
