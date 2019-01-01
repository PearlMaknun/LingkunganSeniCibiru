package io.github.lna.uas.lingkungansenicibiru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KelurahanResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Kelurahan> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Kelurahan> getData() {
        return data;
    }

    public void setData(List<Kelurahan> data) {
        this.data = data;
    }
}
