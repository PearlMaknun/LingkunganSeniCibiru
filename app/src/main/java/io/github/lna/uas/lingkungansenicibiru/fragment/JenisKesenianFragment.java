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
import io.github.lna.uas.lingkungansenicibiru.adapter.JenisSeniAdapter;
import io.github.lna.uas.lingkungansenicibiru.api.ApiClient;
import io.github.lna.uas.lingkungansenicibiru.api.ApiService;
import io.github.lna.uas.lingkungansenicibiru.model.JenisSeni;
import io.github.lna.uas.lingkungansenicibiru.model.JenisSeniResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JenisKesenianFragment extends Fragment {

    private final static String API_KEY = BuildConfig.API_KEY;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;

    public JenisKesenianFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jenis_kesenian, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getData();

        return view;
    }

    public void getData(){

        String message = getString(R.string.loading);
        progressDialog = ProgressDialog.show(getContext(), null, message, true, false);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<JenisSeniResponse> call = apiService.getJenisSeni(API_KEY);

        /*call.enqueue(new Callback<JenisSeniResponse>() {
            @Override
            public void onResponse(Call<JenisSeniResponse> call, Response<JenisSeniResponse> response) {
                try{
                    progressDialog.dismiss();
                    Log.d("response", response.body().toString());
                }catch (Exception e){
                    progressDialog.dismiss();
                    Log.d("error", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JenisSeniResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("why?", "no connection");
            }
        });*/

        call.enqueue(new Callback<JenisSeniResponse>() {
            @Override
            public void onResponse(Call<JenisSeniResponse> call, Response<JenisSeniResponse> response) {
                try{
                    progressDialog.dismiss();
                    final List<JenisSeni> jenisSenis = response.body().getData();
                    Log.d("response", response.body().toString());
                    recyclerView.setAdapter(new JenisSeniAdapter(jenisSenis, R.layout.adapter_list, getContext()));
                }catch (Exception e){
                    progressDialog.dismiss();
                    Log.d("ERROR", e.getMessage());
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JenisSeniResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), getString(R.string.no_internet), Toast.LENGTH_LONG).show();
            }
        });
    }
}
