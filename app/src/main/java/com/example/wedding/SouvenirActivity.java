package com.example.wedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SouvenirActivity extends AppCompatActivity {

    List<Kategori> lstkategori;
    private ArrayList mLocationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir);

        lstkategori = new ArrayList<>();
        lstkategori.add(new Kategori("Sendok Garpu Kayu","Deskripsi :\nGarpu kayu ini berukuran 17.5 cm dengan berat per @ 30 g dan berasal dari kayu sonokeling yang terkenal kuat dan bagus yang berkualitas baik. Biasanya digunakan untuk alat makan, namun bisa juga untuk souvenir dalam berbagai acara\nProses pembuatan membutuhkan waktu 2 – 3 hari",R.drawable.sendokgarpu));
        lstkategori.add(new Kategori("Gantungan Kunci","Deskripsi :\nPersonalisasi desainmu dalam bentuk keychain 2 sisi \nUkuran Media Cetak : Diameter 5cm-7cm\nBahan: Acrylic Bening, Acrylic Kapur\nProses pembuatan 2-3 hari", R.drawable.ganci));
        lstkategori.add(new Kategori("Gelas","Deskripsi :\nKemasan plastik\nGratis : sablon dan kartu ucapan\nBisa request warna sablon\nTinggi gelas 10cm\nDiameter gelas 6cm\nProses pembuatan 2-3 hari", R.drawable.gelas));
        lstkategori.add(new Kategori("Pouch Mini","Deskripsi :\nModel tas (foto tampak depan, belakang & sesudah di packing)\nSablon tahan lama & jelas (tidak luntur)\nBisa di cuci ulang bila kotor\nJahitan kuat & rapi\nBahan kain tebal & kuat menampung beban sampai 10 kg\nProses pembuatan 2-3 hari",R.drawable.pouch));
        lstkategori.add(new Kategori("Flashdisk Kayu","Deskripsi :\nChip GRADE A, BUKAN Chip KW\nChip MERK SANDISK, TOSHIBA atau setara \nREAL CAPACITY\nBisa Untuk meng-COPY FILE BESAR / BERAT (Film, Video, dll)\nGARANSI CHIP 10 TAHUN Tukar Baru\nPRODUKSI CEPAT. Waktu produksi rata-rata lebih cepat dari batas waktu PO\n", R.drawable.fd));

        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstkategori);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);
    }
    
}
