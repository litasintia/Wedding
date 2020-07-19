package com.example.wedding;

public class Kategori2 {

    String id;
    String Nama;
    String Dekorasi;
    String Makeup;
    String Undangan;
    String Souvenir;
    String Nohp;
    String Tanggal;
    String Jenisbayar;
    String Alamat;
    String HrgDekorasi;
    String HrgMakeup;
    String HrgUndangan;
    String HrgSouvenir;
    String Total_Bayar;

    public Kategori2(String id, String nama, String dekorasi, String makeup, String undangan, String souvenir, String nohp, String tanggal, String jenisbayar, String alamat, String hrgDekorasi, String hrgMakeup, String hrgUndangan, String hrgSouvenir, String total_Bayar) {
        this.id = id;
        Nama = nama;
        Dekorasi = dekorasi;
        Makeup = makeup;
        Undangan = undangan;
        Souvenir = souvenir;
        Nohp = nohp;
        Tanggal = tanggal;
        Jenisbayar = jenisbayar;
        Alamat = alamat;
        HrgDekorasi = hrgDekorasi;
        HrgMakeup = hrgMakeup;
        HrgUndangan = hrgUndangan;
        HrgSouvenir = hrgSouvenir;
        Total_Bayar = total_Bayar;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return Nama;
    }

    public String getDekorasi() {
        return Dekorasi;
    }

    public String getMakeup() {
        return Makeup;
    }

    public String getUndangan() {
        return Undangan;
    }

    public String getSouvenir() {
        return Souvenir;
    }

    public String getNohp() {
        return Nohp;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public String getJenisbayar() {
        return Jenisbayar;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getHrgDekorasi() {
        return HrgDekorasi;
    }

    public String getHrgMakeup() {
        return HrgMakeup;
    }

    public String getHrgUndangan() {
        return HrgUndangan;
    }

    public String getHrgSouvenir() {
        return HrgSouvenir;
    }

    public String getTotal_Bayar() {
        return Total_Bayar;
    }
}
