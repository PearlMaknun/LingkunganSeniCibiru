package io.github.lna.uas.lingkungansenicibiru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JenisSeniResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<JenisSeni> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<JenisSeni> getData() {
        return data;
    }

    public void setData(List<JenisSeni> data) {
        this.data = data;
    }

}
