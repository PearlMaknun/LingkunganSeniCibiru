package io.github.lna.uas.lingkungansenicibiru.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.github.lna.uas.lingkungansenicibiru.R;
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

        holder.clayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
/*
    public void getDetail(long id, String judul, String tanggalrilis, String sinopsis, String backdrop, String poster){
        Intent goToDetail = new Intent(context, DetailActivity.class);
        goToDetail.putExtra("id", id);
        goToDetail.putExtra("judul", judul);
        goToDetail.putExtra("tanggalrilis", tanggalrilis);
        goToDetail.putExtra("sinopsis", sinopsis);
        goToDetail.putExtra("backdrop", backdrop);
        goToDetail.putExtra("poster", poster);
        context.startActivity(goToDetail);
    }
*/
    @Override
    public int getItemCount() {
        return jenisSeniListList.size();
    }
}
