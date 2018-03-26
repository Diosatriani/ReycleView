package com.dio.satriani.reycleview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by user on 1/30/2018.
 */

public class OlahragaAdapter extends RecyclerView.Adapter<OlahragaAdapter.OlahragaViewHolder> {
    private Context context;
    private List<OlahragaModel> list;

    public OlahragaAdapter(Context context, List<OlahragaModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public OlahragaAdapter.OlahragaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_olahraga, parent, false);
        return new OlahragaViewHolder(itemView);
    }

    public class OlahragaViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarOlahraga;
        TextView tvNamaOlahraga;
        int post;
        public OlahragaViewHolder(View itemView) {
            super(itemView);
            ivGambarOlahraga = (ImageView) itemView.findViewById(R.id.iv_item_olahraga);
            tvNamaOlahraga = (TextView) itemView.findViewById(R.id.iv_item_olahraga_nama);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    post = getAdapterPosition();
                    Toast.makeText(context, "Post : " + post, Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "Nama  Olahraga : " + tvNamaOlahraga.getText().toString().trim(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, NOOB.class);
                    intent.putExtra("nama", tvNamaOlahraga.getText().toString().trim());
                    context.startActivity(intent);

                }
            });
        }
    }

    @Override
    public void onBindViewHolder(OlahragaAdapter.OlahragaViewHolder holder, int position) {
        holder.ivGambarOlahraga.setImageResource(list.get(position).getGambarOlahraga());
        holder.tvNamaOlahraga.setText(list.get(position).getNamaOlahraga());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Post : ", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
