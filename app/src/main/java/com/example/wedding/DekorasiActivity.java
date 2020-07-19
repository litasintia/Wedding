package com.example.wedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DekorasiActivity extends AppCompatActivity {

    List<Kategori> lstkategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dekorasi);

        lstkategori = new ArrayList<>();
        lstkategori.add(new Kategori("Dekorasi Jawa Modern","Dekorasi Gedung + Pelaminan + Mobil Pengantin\nMC\nUpacara Adat dan Live Music\n± 2 bulan persiapan efektif dengan 2 x Meeting (Preparation Meeting and Final Meeting)\nCrew Utama di Lapangan 6 orang.\n", R.drawable.echadekor));
        lstkategori.add(new Kategori("Dekorasi Tradisional","Dekorasi Gedung + Pelaminan + Mobil Pengantin\nMC\nUpacara Adat\n± 1 bulan persiapan efektif dengan 2 x Meeting (Preparation Meeting and Final Meeting)\nCrew Utama di Lapangan 2 orang.\n", R.drawable.fajarudindekor));
        lstkategori.add(new Kategori("Dekorasi Gabungan","Dekorasi Gedung + Pelaminan + Mobil Pengantin\n MC\nUpacara Adat dan Live Music (Band atau Accoustic)\n± 2 bulan persiapan efektif dengan 2 x Meeting (Preparation Meeting and Final Meeting)\nCrew Utama di Lapangan 6 orang.\n", R.drawable.kinantydekor));
        lstkategori.add(new Kategori("Dekorasi Garden Party","Dekorasi Gedung + Pelaminan + Mobil Pengantin\nMC\nLive Music (Band atau Accoustic)\n± 2 bulan persiapan efektif dengan 2 x Meeting (Preparation Meeting and Final Meeting)\nCrew Utama di Lapangan 6 orang.\n", R.drawable.litawedding));
        lstkategori.add(new Kategori("Dekorasi Elegan","Dekorasi Gedung + Pelaminan + Mobil Pengantin\nMC\nLive Music (Band atau Accoustic)\n± 2 bulan persiapan efektif dengan 2 x Meeting (Preparation Meeting and Final Meeting)\nCrew Utama di Lapangan 6 orang.\n", R.drawable.inovasi));
        lstkategori.add(new Kategori("Dekorasi Minimalis","Dekorasi Gedung + Pelaminan + Mobil Pengantin\nMC\n± 1 bulan persiapan efektif dengan 2 x Meeting (Preparation Meeting and Final Meeting)\nCrew Utama di Lapangan 6 orang.\n",R.drawable.kartini));


        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstkategori);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);


    }
}
