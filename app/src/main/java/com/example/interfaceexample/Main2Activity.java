package com.example.interfaceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.model.SanPham;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int gia=0;
        for(SanPham sanPham : MainActivity.spDcChon){
            gia+=sanPham.getSl()*sanPham.getGia();
    }

        Toast.makeText(Main2Activity.this, "gia = "+gia, Toast.LENGTH_SHORT).show();
}
}
