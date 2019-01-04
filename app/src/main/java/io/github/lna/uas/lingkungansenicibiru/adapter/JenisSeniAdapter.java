package io.github.lna.uas.lingkungansenicibiru.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.R;
import io.github.lna.uas.lingkungansenicibiru.activity.ResultbyKelurahan;
import io.github.lna.uas.lingkungansenicibiru.model.JenisSeni;

public class JenisSeniAdapter extends RecyclerView.Adapter<JenisSeniAdapter.JenisSeniViewHolder>{
    private List<JenisSeni> jenisSeniListList;
    private int clayout;
    private Context context;


    public static class JenisSeniViewHolder extends RecyclerView.ViewHolder {
        LinearLayout clayout;
        TextView cjudul;


        public JenisSeniViewHolder(View itemView) {
            super(itemView);
               clayout = itemView.findViewById(R.id.main_adapter);
               cjudul = itemView.findViewById(R.id.nama_kelurahan);
        }
    }

    public JenisSeniAdapter() {

    }

    public JenisSeniAdapter(List<JenisSeni> jenisSeniListList, int clayout, Context context) {
        this.jenisSeniListList = jenisSeniListList;
        this.clayout = clayout;
        this.context = context;
    }

    @Override
    public JenisSeniAdapter.JenisSeniViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(clayout, parent, false);
        return new JenisSeniViewHolder(view);
    }


    @Override
    public void onBindViewHolder(JenisSeniViewHolder holder, final int position) {
        holder.cjudul.setText(jenisSeniListList.get(position).getNamaJeniskesenian());
        final String id = jenisSeniListList.get(position).getIdJeniskesenian();
        final String nama = jenisSeniListList.get(position).getNamaJeniskesenian();
        holder.clayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ResultbyKelurahan.class);
                i.putExtra("id", id);
                i.putExtra("kelurahan", nama);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jenisSeniListList.size();
    }
}
