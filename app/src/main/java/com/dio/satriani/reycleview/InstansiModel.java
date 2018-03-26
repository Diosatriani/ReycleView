package com.dio.satriani.reycleview;

/**
 * Created by user on 1/31/2018.
 */

public class InstansiModel {

    private String NamaInstansi;
    private String alamat;
    private String jam;
    private  String Donor;

    public InstansiModel(String namaInstansi, String alamat, String jam, String donor) {
        NamaInstansi = namaInstansi;
        this.alamat = alamat;
        this.jam = jam;
        Donor = donor;
    }

    public String getNamaInstansi() {
        return NamaInstansi;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJam() {
        return jam;
    }

    public String getDonor() {
        return Donor;
    }
}
