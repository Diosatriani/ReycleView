package com.dio.satriani.reycleview;

/**
 * Created by user on 1/30/2018.
 */

public class OlahragaModel {
    private int gambarOlahraga;
    private String namaOlahraga;

    public OlahragaModel(int gambarOlahraga, String namaOlahraga) {
        this.gambarOlahraga = gambarOlahraga;
        this.namaOlahraga = namaOlahraga;
    }

    public int getGambarOlahraga() {
        return gambarOlahraga;
    }

    public String getNamaOlahraga() {
        return namaOlahraga;
    }
}
