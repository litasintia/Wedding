package com.example.wedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class KategoriActivity extends AppCompatActivity {

    private TextView tvtitle;
    private TextView description;
    private ImageView thumbnail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        Button btn_tambah = findViewById(R.id.btn_tambah);

        tvtitle = findViewById(R.id.txttitle);
        description = findViewById(R.id.txtdesc);
        thumbnail = findViewById(R.id.image_detail);


        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description =  intent.getExtras().getString("Description");
        int Thumbnail = intent.getExtras().getInt("Thumbnail");


        tvtitle.setText(Title);
        description.setText(Description);
        thumbnail.setImageResource(Thumbnail);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, TambahActivity.class);
                startActivity(intent);
            }
        });


    }

    public void onPressme(View view) {

        Intent intent = new Intent(KategoriActivity.this, TambahActivity.class);
        startActivity(intent);
    }
}
