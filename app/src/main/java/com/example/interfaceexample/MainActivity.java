package com.example.interfaceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.SanPhamAdapter;
import com.example.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ValuesInterface {

    ListView lvSanPham;
    ArrayList<SanPham> arrSP;
    SanPhamAdapter adapterSP;
    ImageView imgAbtract, imgPlus;

    Button btnNext;
    int dem = 0;

    public static ArrayList<SanPham> spDcChon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        setupData();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyDaChon();

            }
        });

    }

    private void xuLyDaChon() {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);


        startActivity(intent);
    }

    private void addControls() {
        btnNext = findViewById(R.id.btnNext);

        lvSanPham = findViewById(R.id.lvSanPham);
        arrSP = new ArrayList<SanPham>();
        adapterSP = new SanPhamAdapter(MainActivity.this, R.layout.item, arrSP, this);
//        adapterSP.isClicked(this);
        lvSanPham.setAdapter(adapterSP);

        spDcChon = new ArrayList<SanPham>();
    }


    private void setupData() {
        for (int i = 0; i <= 500; i++) {

            SanPham sanPham = new SanPham(R.drawable.icon_sp2, "Ao do", 200000, 0);
            ;
            arrSP.add(sanPham);
            sanPham = new SanPham(R.drawable.icon_sp1, "Ao den", 300000, 0);
            ;
            arrSP.add(sanPham);
            sanPham = new SanPham(R.drawable.icon_sp3, "Ao vang", 400000, 0);
            ;
            arrSP.add(sanPham);
            sanPham = new SanPham(R.drawable.icon_sp4, "Ao thun trang", 500000, 0);
            ;
            arrSP.add(sanPham);
            sanPham = new SanPham(R.drawable.icon_sp5, "Ao jean xanh", 600000, 0);
            ;
            arrSP.add(sanPham);
            sanPham = new SanPham(R.drawable.icon_sp6, "Ao lot trang", 700000, 0);
            ;
            arrSP.add(sanPham);
        }
    }

    @Override
    public void PlusClick(int position) {
        dem += 1;

        SanPham sanPham = arrSP.get(position);
        sanPham.setSl(dem);
        spDcChon.add(sanPham);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Abtract(int position) {
        dem -= 1;

        SanPham sanPham = arrSP.get(position);
        sanPham.setSl(dem);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


}
