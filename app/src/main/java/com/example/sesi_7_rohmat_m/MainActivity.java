package com.example.sesi_7_rohmat_m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GolonganDarah GolonganDarahSelected = new GolonganDarah();
    Spinner spiGolonganDarah;
    RadioGroup rgJenisKelamin;
    String JenisKelaminSelected;
    Button btnsubmit;
    EditText nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spiGolonganDarah = findViewById(R.id.spiGolonganDarah);
        rgJenisKelamin = findViewById(R.id.rgJenisKelamin);
        btnsubmit = findViewById(R.id.btnsubmit);
        nama = findViewById(R.id.nama);

        final ArrayList<GolonganDarah> golonganDarahArrayList = new ArrayList<>();
        golonganDarahArrayList.add(new GolonganDarah(0, "-"));
        golonganDarahArrayList.add(new GolonganDarah(1, "A"));
        golonganDarahArrayList.add(new GolonganDarah(2, "B"));
        golonganDarahArrayList.add(new GolonganDarah(3, "AB"));
        golonganDarahArrayList.add(new GolonganDarah(4, "O"));

        ArrayAdapter adapterGolonganDarah = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, golonganDarahArrayList);
        adapterGolonganDarah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiGolonganDarah.setAdapter(adapterGolonganDarah);
        spiGolonganDarah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GolonganDarah golonganDarah = (GolonganDarah) parent.getItemAtPosition(position);
                GolonganDarahSelected.setId(golonganDarah.getId());
                GolonganDarahSelected.setJenis(golonganDarah.getJenis());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rgJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioLaki) {
                    JenisKelaminSelected = "Laki-Laki";
                } else {
                    JenisKelaminSelected = "Perempuan";
                }
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama.getText().toString().length()==0){
                    nama.setError("Tidak Boleh Kosong!");}
                    else {
                    Toast.makeText(MainActivity.this, String.format("\n Nama Mahasiswa : %s" + "\nJenis Kelamin: %s" + "\n Golongan Darah: %s", nama.getText(), JenisKelaminSelected, GolonganDarahSelected.getJenis()),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

