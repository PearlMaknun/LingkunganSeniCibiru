package io.github.lna.uas.lingkungansenicibiru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LingkunganSeniResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<LingkunganSeni> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LingkunganSeni> getData() {
        return data;
    }

    public void setData(List<LingkunganSeni> data) {
        this.data = data;
    }

}
