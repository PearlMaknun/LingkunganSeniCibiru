package io.github.lna.uas.lingkungansenicibiru.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.activity.ResultbyKelurahan;
import io.github.lna.uas.lingkungansenicibiru.model.Kelurahan;

public class KelurahanAdapter extends RecyclerView.Adapter<KelurahanAdapter.KelurahanViewHolder>{
    private List<Kelurahan> kelurahanListList;
    private int clayout;
    private Context context;


    public static class KelurahanViewHolder extends RecyclerView.ViewHolder {
        LinearLayout clayout;
        TextView cjudul;


        public KelurahanViewHolder(View itemView) {
            super(itemView);
            clayout = itemView.findViewById(R.id.main_adapter);
            cjudul = itemView.findViewById(R.id.nama_kelurahan);
        }
    }

    public KelurahanAdapter() {

    }

    public KelurahanAdapter(List<Kelurahan> kelurahanListList, int clayout, Context context) {
        this.kelurahanListList = kelurahanListList;
        this.clayout = clayout;
        this.context = context;
    }

    @Override
    public KelurahanAdapter.KelurahanViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(clayout, parent, false);
        return new KelurahanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelurahanAdapter.KelurahanViewHolder holder, int position) {
        holder.cjudul.setText(kelurahanListList.get(position).getNamaKelurahan());
        final String id = kelurahanListList.get(position).getIdKelurahan();
        final String nama = kelurahanListList.get(position).getNamaKelurahan();

        holder.clayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(context, Beranda.class);
                i.putExtra("menu", 1);
                i.putExtra("tab", 2);
                i.putExtra("id", id);
                context.startActivity(i);*/
                Intent i = new Intent(context, ResultbyKelurahan.class);
                i.putExtra("id", id);
                i.putExtra("kelurahan", nama);
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return kelurahanListList.size();
    }
}
