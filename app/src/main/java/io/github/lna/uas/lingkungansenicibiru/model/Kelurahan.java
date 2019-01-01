package io.github.lna.uas.lingkungansenicibiru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kelurahan {

    @SerializedName("id_kelurahan")
    @Expose
    private String idKelurahan;
    @SerializedName("nama_kelurahan")
    @Expose
    private String namaKelurahan;

    public String getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(String idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getNamaKelurahan() {
        return namaKelurahan;
    }

    public void setNamaKelurahan(String namaKelurahan) {
        this.namaKelurahan = namaKelurahan;
    }
}
