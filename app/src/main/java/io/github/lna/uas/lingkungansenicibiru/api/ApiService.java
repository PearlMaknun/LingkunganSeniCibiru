package io.github.lna.uas.lingkungansenicibiru.api;

import io.github.lna.uas.lingkungansenicibiru.model.JenisSeniResponse;
import io.github.lna.uas.lingkungansenicibiru.model.KelurahanResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService  {

    @GET("jeniskesenian/")
    Call<JenisSeniResponse> getJenisSeni(@Query("key") String apiKey);

    @GET("kelurahan/")
    Call<KelurahanResponse> getKelurahan(@Query("key") String apiKey);

}
