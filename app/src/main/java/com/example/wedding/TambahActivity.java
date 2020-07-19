package com.example.wedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahActivity extends AppCompatActivity {


    EditText etNama;
    TextView pilihDekorasi, pilihMakeup, pilihUndangan, pilihSouvenir;
    EditText etAlamat;
    EditText etCatatan;
    EditText pesUndangan, pesSouvenir;
    int hrgUndangan;
    int hrgSouvenir;
    EditText etnoHp;
    TextView etTotal;
    RadioGroup rgJenis;
    RadioButton rbJenis;
    Button btn_submit;
    Spinner dekorasi, makeup, undangan, souvenir;
    int total;
    int hargaDekorasi[] = {0,23700000, 15000000, 25000000, 27000000, 24000000, 15700000};
    int hargaMakeup[] = {0,5000000, 8000000, 5000000, 8800000, 5000000};
    int hargaUndangan[] = {0,5000, 10000, 10000, 5000, 20000};
    int hargaSouvenir[] = {0,20000, 5000, 25000, 20000, 100000};

    String spindekorasi[] = {"Pilih Dekorasi","Dekorasi Jawa Modern", "Dekorasi Tradisional", "Dekorasi Gabungan", "Dekorasi Garden Party", "Dekorasi Elegan", "Dekorasi Minimalis"};
    String spinmakeup[] = {"Pilih Make Up", "Make Up Tradisional Modern", "Make Up Trp Bridal Modern", "Make Up Hijab Syari Modern", "Make Up India", "Make Up Korea"};
    String spinundangan[] = {"Pilih Undangan", "Undangan Kipas", "Undangan Gulung", "Undangan Hard Cover", "Undangan Full Cover", "Undangan Kalender"};
    String spinsouvenir[] = {"Pilih Souvenir", "Souvenir Sendok Garpu", "Souvenir Gantuan Kunci", "Souvenir Gelas", "Souvenir Pouch Mini", "Souvenir Flashdisk"};

    DatabaseReference databasePemesan;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;
    private TextView tvDateResult;
    private EditText btDatePicker;


    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvDateResult.setText(dateFormat.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        databasePemesan = FirebaseDatabase.getInstance().getReference("Data_Pembeli");

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        //inisialisasi
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = findViewById(R.id.tv_dateresult);
        btDatePicker = findViewById(R.id.tv_dateresult);

        etNama = findViewById(R.id.et_nama);
        pilihDekorasi = findViewById(R.id.pilih_dekorasi);
        pilihMakeup = findViewById(R.id.pilih_makeup);
        pilihUndangan = findViewById(R.id.pilih_undangan);
        pilihSouvenir = findViewById(R.id.pilih_souvenir);
        etnoHp = findViewById(R.id.et_id);
        etAlamat = findViewById(R.id.et_domisili);
        rgJenis = findViewById(R.id.rg_jenispembayaran);
        dekorasi = findViewById(R.id.Dekorasi);
        makeup = findViewById(R.id.Makeup);
        undangan = findViewById(R.id.Undangan);
        souvenir = findViewById(R.id.souvenir);
        pesUndangan = findViewById(R.id.pes_undangan);
        pesSouvenir = findViewById(R.id.jml_souvenir1);
        etTotal = findViewById(R.id.total_harga);


        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = rgJenis.getCheckedRadioButtonId();
                rbJenis = findViewById(radioId);

                getDataPemesan();



            }
        });

        etTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTotal();

            }
        });

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(TambahActivity.this,android.R.layout.simple_list_item_1,spindekorasi);
        dekorasi.setAdapter(arrayAdapter1);

        dekorasi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select = dekorasi.getItemAtPosition(position).toString();

                if(select == spindekorasi[0]) {
                    pilihDekorasi.setText(String.valueOf(hargaDekorasi[0]));

                }else if (select == spindekorasi[1]){
                    pilihDekorasi.setText(String.valueOf(hargaDekorasi[1]));
                }
                else if (select == spindekorasi[2]){
                    pilihDekorasi.setText(String.valueOf(hargaDekorasi[2]));
                }
                else if (select == spindekorasi[3]){
                    pilihDekorasi.setText(String.valueOf(hargaDekorasi[3]));
                }
                else if (select == spindekorasi[4]){
                    pilihDekorasi.setText(String.valueOf(hargaDekorasi[4]));
                }
                else if (select == spindekorasi[5]){
                    pilihDekorasi.setText(String.valueOf(hargaDekorasi[5]));
                }else {
                    pilihDekorasi.setText("0");

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(TambahActivity.this,android.R.layout.simple_list_item_1,spinmakeup);
        makeup.setAdapter(arrayAdapter2);
        makeup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select = makeup.getItemAtPosition(position).toString();

                if(select == spinmakeup[0]) {
                    pilihMakeup.setText(String.valueOf(hargaMakeup[0]));

                }else if (select == spinmakeup[1]){
                    pilihMakeup.setText(String.valueOf(hargaMakeup[1]));
                }
                else if (select == spinmakeup[2]){
                    pilihMakeup.setText(String.valueOf(hargaMakeup[2]));
                }
                else if (select == spinmakeup[3]) {
                    pilihMakeup.setText(String.valueOf(hargaMakeup[3]));
                }
                else if (select == spinmakeup[4]) {
                    pilihMakeup.setText(String.valueOf(hargaMakeup[4]));
                }
                else {
                    pilihMakeup.setText("0");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(TambahActivity.this,android.R.layout.simple_list_item_1,spinundangan);
        undangan.setAdapter(arrayAdapter3);

        undangan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select = undangan.getItemAtPosition(position).toString();

                if(select == spinundangan[0]) {
                    pilihUndangan.setText(String.valueOf(hargaUndangan[0]));

                }else if (select == spinundangan[1]){
                    pilihUndangan.setText(String.valueOf(hargaUndangan[1]));
                }
                else if (select == spinundangan[2]){
                    pilihUndangan.setText(String.valueOf(hargaUndangan[2]));
                }
                else if (select == spinundangan[3]){
                    pilihUndangan.setText(String.valueOf(hargaUndangan[3]));
                }
                else if (select == spinundangan[4]){
                    pilihUndangan.setText(String.valueOf(hargaUndangan[4]));
                }else {
                    pilihUndangan.setText("0");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(TambahActivity.this,android.R.layout.simple_list_item_1,spinsouvenir);
        souvenir.setAdapter(arrayAdapter4);
        souvenir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select = souvenir.getItemAtPosition(position).toString();

                if(select == spinsouvenir[0]) {
                    pilihSouvenir.setText(String.valueOf(hargaSouvenir[0]));

                }else if (select == spinsouvenir[1]){
                    pilihSouvenir.setText(String.valueOf(hargaSouvenir[1]));
                }
                else if (select == spinsouvenir[2]){
                    pilihSouvenir.setText(String.valueOf(hargaSouvenir[2]));
                }
                else if (select == spinsouvenir[3]){
                    pilihSouvenir.setText(String.valueOf(hargaSouvenir[3]));
                }
                else if (select == spinsouvenir[4]){
                    pilihSouvenir.setText(String.valueOf(hargaSouvenir[4]));
                }else {
                    pilihSouvenir.setText("0");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });



        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = findViewById(R.id.tv_dateresult);
        btDatePicker = findViewById(R.id.tv_dateresult);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

    }


    public void getTotal(){
        int totalspin1 = Integer.parseInt(pilihDekorasi.getText().toString());
        int totalspin2 = Integer.parseInt(pilihMakeup.getText().toString());
        int totalspin3 = Integer.parseInt(pilihUndangan.getText().toString());
        int totalspin4 = Integer.parseInt(pilihSouvenir.getText().toString());
        int jumUndangan = Integer.parseInt(pesUndangan.getText().toString());
        int jumSouvenir = Integer.parseInt(pesSouvenir.getText().toString());

        total =totalspin1+totalspin2+totalspin3*jumUndangan+totalspin4*jumSouvenir;
        etTotal.setText(String.valueOf(total));
    }


    private void getDataPemesan() {
        String Nama = etNama.getText().toString();
        String Nohp = etnoHp.getText().toString();
        String HDekorasi = pilihDekorasi.getText().toString();
        String HMakeup = pilihMakeup.getText().toString();
        String HUndangan = pilihUndangan.getText().toString();
        String HSouvenir = pilihSouvenir.getText().toString();
        String Tanggal = btDatePicker.getText().toString();
        String Alamat = etAlamat.getText().toString();
        String Jenisbayar = rbJenis.getText().toString();
        String Total_Bayar = etTotal.getText().toString();
        String Dekorasi  = String.valueOf(dekorasi.getSelectedItem());
        String Makeup= String.valueOf(makeup.getSelectedItem());
        String Undangan= String.valueOf(undangan.getSelectedItem());
        String Souvenir= String.valueOf(souvenir.getSelectedItem());
        String pilih = "";

        if (Nama.isEmpty()) {

            etNama.setError("Nama tidak boleh kosong");
            etNama.requestFocus();
            return;

        }
        if (Nama.length() < 10) {
            etNama.setError("Nama Harus lebih dari 2 karakter");
            return;
        }
        if (Nohp.isEmpty()) {
            etnoHp.setError("Nomor Hp tidak boleh kosong");
            etnoHp.requestFocus();
            return;
        }
        if (Nohp.length() < 12) {
            etnoHp.setError("Masukkan nomer telephone yang benar");
            return;
        }
        if (Alamat.isEmpty()) {
            etAlamat.setError("Alamat tidak boleh kosong");
            etAlamat.requestFocus();
            return;
        }
        if(!TextUtils.isEmpty(Nama)){

            String id = databasePemesan.push().getKey();

            Kategori2 kategori2 = new Kategori2(id, Nama, Dekorasi, Makeup, Undangan, Souvenir, Nohp, Tanggal, Jenisbayar, Alamat, HDekorasi, HMakeup, HUndangan, HSouvenir, Total_Bayar);

            databasePemesan.child(id).setValue(kategori2);

            Toast.makeText(this, "Pesanan Dibuat", Toast.LENGTH_LONG).show();


        }else {
            Toast.makeText(this,"Anda Belum Mengisi Pemesanan", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(TambahActivity.this, LihatPesanan.class);
        intent.putExtra("extraNama", Nama);
        intent.putExtra("extraNohp", Nohp);
        intent.putExtra("extraTanggal", Tanggal);
        intent.putExtra("extraAlamat", Alamat);
        intent.putExtra("extraTotal", Total_Bayar);
        intent.putExtra("extraPilih", pilih);
        startActivity(intent);



    }


}


