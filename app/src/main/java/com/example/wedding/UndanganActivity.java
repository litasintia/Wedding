package com.example.wedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UndanganActivity extends AppCompatActivity {

    List<Kategori> lstkategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undangan);

        lstkategori = new ArrayList<>();
        lstkategori.add(new Kategori("Undangan Kipas","Deskripsi :\nGambar bisa request\nProses Satu Hari Jadi Langsung Kirim\nGambar Bolak Balik : Beda/Sama\nBentuk : Bulat/Persegi\nBahan : Art Papper 310gr + laminasi gliter/kanvas\nGagang kipas : Biru, Putih, Pink Fanta, Hitam, Merah",R.drawable.kipas));
        lstkategori.add(new Kategori("Undangan Gulung","Deskripsi :\nUNDANGAN GULUNG KEMASAN BAMBU\n\nKemasan luar dengan bambu model kentongan ato bisa juga model Bambu Full\nIsi dengan kertas Samson (warna coklat natural), cetak tinta 1 warna, bolak blk.\nCetak isi 1 warna, bisa pilih warna sesuai REQUEST. Misalkan marun, coklat, hitam, dll.\nUkuran 19 x 30 cm.\nUjung bambu ada manik-manik emas\nProses produksi 10 hari",R.drawable.ugulung));
        lstkategori.add(new Kategori("Undangan Hard Cover","Deskripsi :\n Undangan Single Hardcover + Amplop Bahan sangat Tebal +-3mm\n Gratis :\nKartu ucapan terimakasih dan Label Nama (dapat dua-duanya)\nPlastik Undangan\nDenah Lokasi\nQR Code/ Barcode Google Maps\nRevisi Berkali-kali Sampai ACC\nPacking Bubble Wrap atau Kardus\nPREVIEW DESIGN  sebelum cetak (jadi bisa revisi jika ada yg belum pas).",R.drawable.hc));
        lstkategori.add(new Kategori("Undangan Full Color","Deskripsi :\nUkuran Terbuka : 18,6 x 26 (Cm)\nUkuran Tertutup : 18,6 x 13 (Cm)\nUkuran Plastik : 13,5 x 22 (Cm)\nJenis Kertas : BC\nJenis Blangko : Softcover\nFoil : Tidak ada", R.drawable.fc));
        lstkategori.add(new Kategori("Undangan Kalender","Deskripsi :\nUkuran: 10 x 15 cm\nTerdiri dari\n1. Cover 2 lember (depan & Belakang) : Kertas Ivory 260 grm\n2. Isi: 3 lembar full color Kertas Ivory 230 grm\nbisa ditambah lembaran isi dengan tambahan biaya \n3. Isi Kalender 12 bulan 2019: 3 lembar (Bolak-Balik) kertas Ivory 210 gram\n4. Jilid Spiral Kawat 6 Lubang\nGratis :\n- Plastik\n- Label Nama Tamu\n- Gratis Print nama Tamu di Label (kirim lewa WA dan sudah diketik di Ms. excel) \n",R.drawable.ukalender));

        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstkategori);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);
    }
}
