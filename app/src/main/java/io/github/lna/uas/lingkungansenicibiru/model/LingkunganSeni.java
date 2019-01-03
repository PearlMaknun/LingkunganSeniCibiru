package io.github.lna.uas.lingkungansenicibiru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LingkunganSeni {

    @SerializedName("id_lingkunganseni")
    @Expose
    private String idLingkunganseni;
    @SerializedName("nama_lingkunganseni")
    @Expose
    private String namaLingkunganseni;
    @SerializedName("pimpinan")
    @Expose
    private String pimpinan;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("tahun_berdiri")
    @Expose
    private String tahunBerdiri;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("fk_kelurahan")
    @Expose
    private String fkKelurahan;
    @SerializedName("tag_jeniskesenian")
    @Expose
    private String tagJeniskesenian;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;

    public String getIdLingkunganseni() {
        return idLingkunganseni;
    }

    public void setIdLingkunganseni(String idLingkunganseni) {
        this.idLingkunganseni = idLingkunganseni;
    }

    public String getNamaLingkunganseni() {
        return namaLingkunganseni;
    }

    public void setNamaLingkunganseni(String namaLingkunganseni) {
        this.namaLingkunganseni = namaLingkunganseni;
    }

    public String getPimpinan() {
        return pimpinan;
    }

    public void setPimpinan(String pimpinan) {
        this.pimpinan = pimpinan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTahunBerdiri() {
        return tahunBerdiri;
    }

    public void setTahunBerdiri(String tahunBerdiri) {
        this.tahunBerdiri = tahunBerdiri;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFkKelurahan() {
        return fkKelurahan;
    }

    public void setFkKelurahan(String fkKelurahan) {
        this.fkKelurahan = fkKelurahan;
    }

    public String getTagJeniskesenian() {
        return tagJeniskesenian;
    }

    public void setTagJeniskesenian(String tagJeniskesenian) {
        this.tagJeniskesenian = tagJeniskesenian;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }
}
