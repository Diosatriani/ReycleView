package com.dio.satriani.reycleview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    String [] namaOlahraga = {"Sepak Bola",
            "Basket",
            "PingPong"};
    int [] gambarOlahraga = {R.drawable.ball,
            R.drawable.basket,
            R.drawable.pingpong};
    RecyclerView rvOlahraga;



    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

}
