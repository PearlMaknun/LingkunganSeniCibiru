package io.github.lna.uas.lingkungansenicibiru.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //public static final String BASE_URL = "http://localhost:8080/";
    public static final String BASE_URL = "https://lingkungansenicibiru.000webhostapp.com/public/";
    //https://lingkungansenicibiru.000webhostapp.com/
    //http://192.168.56.1:8080/
    
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
