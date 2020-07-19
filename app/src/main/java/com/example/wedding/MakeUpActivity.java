package com.example.wedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class  MakeUpActivity extends AppCompatActivity {


    List<Kategori> lstkategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);

        lstkategori = new ArrayList<>();
        lstkategori.add(new Kategori("Make up tradisional", "Tata rias pengantin Jawa mempunyai kekhasan yaitu berupa Paes di dahi wanita sebagai perlambang keanggunan dan ketundukan wanita pada suami ini.\nTata rias Pengantin sunda adalah adanya penggunaan Siger sebagai mahkota dan daun sirih di dahi. Tata rias yang akan membuat anda terlihat elegan", R.drawable.mua_tm));
        lstkategori.add(new Kategori("Make up Trp Bridal Modern", "TRP bridal modern  menggunakan gaun putih panjang dengan tatan rambut modern sambil memegang bunga. Tata rias ini akan membuat anda tampil flawless dan percaya diri di hari bahagia", R.drawable.mua_trpbridal));
        lstkategori.add(new Kategori("Make up Hijab Syar'i Modern", "Para muslimah yang menginginkan gaya busana tertutup juga semakin banyak, sehingga tradisi hijab ini semakin banyak dan menyesuaikan perkembangan zaman. Tatarias ini sangat cocok untuk wanita muslimah yang ingin terlihat cantik dan elegan dihari yang berbahagia ", R.drawable.mua_syari));
        lstkategori.add(new Kategori("Make up India", "Tata rias ala India ini merupakan slaah satu tata rias yang banyak diminati oleh wanita yang ingin terlihat glamour di acara pernikahnnya. Tata rias ini akan membuat anda terlihat beda dari sebelumnya yang akan membuat semua orang terpesona", R.drawable.mua_india));
        lstkategori.add(new Kategori("Make up Korea","Korean makeup look merupakan salah satu makeup yang sedang trending di semua kalangan, konsepnya sangat praktis namun akan terlihat flawless dan fresh yang akan membuat penampilanmu menjadi begitu menawan", R.drawable.mua_korea));


        RecyclerView myrv = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstkategori);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);


    }
}
