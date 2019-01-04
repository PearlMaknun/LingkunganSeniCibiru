package io.github.lna.uas.lingkungansenicibiru.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.activity.DetailJenisLingkungan;
import io.github.lna.uas.lingkungansenicibiru.model.LingkunganSeni;

public class LingkunganSeniAdapter extends RecyclerView.Adapter<LingkunganSeniAdapter.LingkunganSeniViewHolder>{
    private List<LingkunganSeni> lingkunganSeniList;
    private int clayout;
    private Context context;


    public static class LingkunganSeniViewHolder extends RecyclerView.ViewHolder {
        LinearLayout clayout;
        TextView cjudul, cjk;
        ImageView cimage;


        public LingkunganSeniViewHolder(View itemView) {
            super(itemView);
            clayout = itemView.findViewById(R.id.adapter_lingkungan);
            cjudul = itemView.findViewById(R.id.nama_lingkungan);
            cjk = itemView.findViewById(R.id.jenis_kesenian);
            cimage = itemView.findViewById(R.id.image_lingkungan);
        }
    }

    public LingkunganSeniAdapter() {

    }

    public LingkunganSeniAdapter(List<LingkunganSeni> lingkunganSeniList, int clayout, Context context) {
        this.lingkunganSeniList = lingkunganSeniList;
        this.clayout = clayout;
        this.context = context;
    }

    @Override
    public LingkunganSeniAdapter.LingkunganSeniViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(clayout, parent, false);
        return new LingkunganSeniViewHolder(view);
    }


    @Override
    public void onBindViewHolder(LingkunganSeniViewHolder holder, final int position) {
        final String id = lingkunganSeniList.get(position).getIdLingkunganseni();
        /*final String nama = lingkunganSeniList.get(position).getNamaLingkunganseni();
        final String alamat = lingkunganSeniList.get(position).getAlamat();
        final String deskripsi = lingkunganSeniList.get(position).getDeskripsi();
        final String kelurahan = lingkunganSeniList.get(position).getFkKelurahan();
        final String foto = lingkunganSeniList.get(position).getFoto();
        final String lat = lingkunganSeniList.get(position).getLat();
        final String longtitude = lingkunganSeniList.get(position).getLong();
        final String pimpinan = lingkunganSeniList.get(position).getPimpinan();
        final String jeniskesenian = lingkunganSeniList.get(position).getTagJeniskesenian();
        final String tahun = lingkunganSeniList.get(position).getTahunBerdiri();*/

        holder.cjudul.setText(lingkunganSeniList.get(position).getNamaLingkunganseni());
        holder.cjk.setText(lingkunganSeniList.get(position).getTagJeniskesenian());
        if(lingkunganSeniList.get(position).getFoto() == ""){
            Glide.with(context)
                    .load(R.drawable.pict_teras)
                    .into(holder.cimage);
        }else{
            Glide.with(context)
                    .load(lingkunganSeniList.get(position).getFoto())
                    .into(holder.cimage);
        }
        holder.clayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailJenisLingkungan.class);
                i.putExtra("id", id);
                /*i.putExtra("nama", nama);
                i.putExtra("alamat", alamat);
                i.putExtra("deskripsi", deskripsi);
                i.putExtra("kelurahan", kelurahan);
                i.putExtra("foto", foto);
                i.putExtra("lat", lat);
                i.putExtra("long", longtitude);
                i.putExtra("pimpinan", pimpinan);
                i.putExtra("jeniskesenian", jeniskesenian);
                i.putExtra("tahun", tahun);*/
                context.startActivity(i);

                /*Intent i = new Intent(context, DetailCadangan.class);
                i.putExtra("id", id);
                i.putExtra("nama", nama);
                i.putExtra("alamat", alamat);
                i.putExtra("deskripsi", deskripsi);
                i.putExtra("kelurahan", kelurahan);
                i.putExtra("foto", foto);
                i.putExtra("lat", lat);
                i.putExtra("long", longtitude);
                i.putExtra("pimpinan", pimpinan);
                i.putExtra("jeniskesenian", jeniskesenian);
                i.putExtra("tahun", tahun);
                context.startActivity(i);
                */
            }
        });
    }

    @Override
    public int getItemCount() {
        return lingkunganSeniList.size();
    }
}
