package com.dio.satriani.reycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 1/31/2018.
 */

public class InstansiAdapter extends RecyclerView.Adapter<InstansiAdapter.InstansiViewHolder> {

    Context context;
    private List<InstansiModel> instansiModels;

    public InstansiAdapter(Context context, List<InstansiModel> instansiModeles) {
        this.context = context;
        this.instansiModels = instansiModeles;
    }

    @Override
    public InstansiAdapter.InstansiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_instansi, parent, false);
        return new  InstansiViewHolder(view);
    }

    public class InstansiViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaInstansi, tv_NamaAlamat, tv_jam, tv_donor;
        public InstansiViewHolder(View itemView) {
            super(itemView);
            tv_NamaInstansi = itemView.findViewById(R.id.tv_NamaInstansi);
            tv_NamaAlamat = itemView.findViewById(R.id.tv_NamaAlamat);
            tv_jam = itemView.findViewById(R.id.tv_NamaJam);
            tv_donor = itemView.findViewById(R.id.tv_NamaDonor);
        }
    }

    @Override
    public void onBindViewHolder(InstansiAdapter.InstansiViewHolder holder, int position) {

        holder.tv_NamaInstansi.setText(instansiModels.get(position).getNamaInstansi());
        holder.tv_NamaAlamat.setText(instansiModels.get(position).getAlamat());
        holder.tv_jam.setText(instansiModels.get(position).getJam());
        holder.tv_donor.setText(instansiModels.get(position).getDonor());
    }

    @Override
    public int getItemCount() {
        return instansiModels.size();
    }


}
