package io.github.lna.uas.lingkungansenicibiru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JenisSeni {

    @SerializedName("id_jeniskesenian")
    @Expose
    private String idJeniskesenian;
    @SerializedName("nama_jeniskesenian")
    @Expose
    private String namaJeniskesenian;

    public String getIdJeniskesenian() {
        return idJeniskesenian;
    }

    public void setIdJeniskesenian(String idJeniskesenian) {
        this.idJeniskesenian = idJeniskesenian;
    }

    public String getNamaJeniskesenian() {
        return namaJeniskesenian;
    }

    public void setNamaJeniskesenian(String namaJeniskesenian) {
        this.namaJeniskesenian = namaJeniskesenian;
    }

}
