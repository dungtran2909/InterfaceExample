package com.example.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    int imgSP;
    String Ten;
    int Gia;
    int sl;

    public SanPham() {
    }

    public SanPham(int imgSP, String ten, int gia, int sl) {
        this.imgSP = imgSP;
        Ten = ten;
        Gia = gia;
        this.sl = sl;
    }

    public int getImgSP() {
        return imgSP;
    }

    public void setImgSP(int imgSP) {
        this.imgSP = imgSP;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    @Override
    public String toString() {
        return this.Ten + "\n" + this.Gia;
    }
}
