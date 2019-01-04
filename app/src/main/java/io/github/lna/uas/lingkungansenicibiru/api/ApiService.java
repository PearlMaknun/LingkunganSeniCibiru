package io.github.lna.uas.lingkungansenicibiru.api;

import io.github.lna.uas.lingkungansenicibiru.model.JenisSeniResponse;
import io.github.lna.uas.lingkungansenicibiru.model.KelurahanResponse;
import io.github.lna.uas.lingkungansenicibiru.model.LingkunganSeniResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService  {

    @GET("jeniskesenian/")
    Call<JenisSeniResponse> getJenisSeni(@Query("key") String apiKey);

    @GET("kelurahan/")
    Call<KelurahanResponse> getKelurahan(@Query("key") String apiKey);

    @GET("lingkunganseni/kelurahan/{id}")
    Call<LingkunganSeniResponse> getLingSenibyKelurahan(@Path ("id") String id, @Query("key") String apiKey);

    @GET("lingkunganseni/search/")
    Call<LingkunganSeniResponse> getSearch(@Query ("keyword") String keyword, @Query("key") String apiKey);

    @GET("lingkunganseni/{id}")
    Call<LingkunganSeniResponse> getDetail(@Path("id") String id, @Query("key") String apiKey);
}
