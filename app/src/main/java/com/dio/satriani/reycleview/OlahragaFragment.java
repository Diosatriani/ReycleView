package com.dio.satriani.reycleview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OlahragaFragment extends Fragment {

    String [] namaOlahraga = {"Sepak Bola",
            "Basket",
            "PingPong"};
    int [] gambarOlahraga = {R.drawable.ball,
            R.drawable.basket,
            R.drawable.pingpong};
    RecyclerView rvOlahraga;

    public OlahragaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_olahraga, container, false);
        rvOlahraga = (RecyclerView) view.findViewById(R.id.rv_olahraga);

        //menentukan bentuk RecycleView Disini milihnya listview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),0,false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        //memasukan settingan yang dipilih ke recyclerview
        rvOlahraga.setLayoutManager(gridLayoutManager);
        //membuat objek olahraga list
        ArrayList<OlahragaModel> list = new ArrayList<>();

        for (int i = 0; i < namaOlahraga.length ; i++) {
            OlahragaModel olahragaModel = new OlahragaModel(gambarOlahraga[i],
                    namaOlahraga[i]);
            list.add(olahragaModel);

        }
        OlahragaAdapter olahragaAdapter = new OlahragaAdapter(getActivity(), list);
        rvOlahraga.setAdapter(olahragaAdapter);
        return view;
    }

}
