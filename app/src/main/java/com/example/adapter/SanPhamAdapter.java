package com.example.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interfaceexample.R;
import com.example.interfaceexample.ValuesInterface;
import com.example.model.SanPham;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Context context;
    int resource;
    List<SanPham> arrSanpham;
    ValuesInterface valuesInterface;

    public void isClicked(ValuesInterface valuesInterface){
        this.valuesInterface = valuesInterface;
    }

    public SanPhamAdapter(Context context, int resource, List<SanPham> arrSanpham,ValuesInterface valuesInterface)  {
        super(context,resource,arrSanpham);
        this.context = context;
        this.resource = resource;
        this.arrSanpham = arrSanpham;
        this.valuesInterface =valuesInterface;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        LayoutInflater inflater = LayoutInflater.from(this.context);
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item,null);
            holder.imgSanPham = convertView.findViewById(R.id.imgSanPham);
            holder.txtTen = convertView.findViewById(R.id.txtTen);
            holder.txtGia = convertView.findViewById(R.id.txtGia);
            holder.imgAbtract = convertView.findViewById(R.id.imgAbtract);
            holder.imgPlus = convertView.findViewById(R.id.imgPlus);
            holder.txtNumber = convertView.findViewById(R.id.txtNumber);

            int dem = 0;

            holder.imgAbtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valuesInterface.Abtract(position);
                    int dem = Integer.parseInt(holder.txtNumber.getText().toString())-1;
                    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                    holder.txtNumber.setText(decimalFormat.format(dem));

                }
            });

            holder.imgPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valuesInterface.PlusClick(position);
                    int dem = Integer.parseInt(holder.txtNumber.getText().toString())+1;
                    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                    holder.txtNumber.setText(decimalFormat.format(dem));
                }
            });

            holder.position = position;
            holder.sl= dem;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        SanPham sanPham = arrSanpham.get(position);
        holder.imgSanPham.setImageResource(sanPham.getImgSP());
        holder.txtTen.setText(sanPham.getTen());
        holder.txtGia.setText(sanPham.getGia()+"");
        holder.txtNumber.setText(sanPham.getSl()+"");

        return convertView;
    }

    public static class ViewHolder{
        ImageView imgSanPham;
        TextView txtTen;
        TextView txtGia;
        ImageView imgAbtract;
        ImageView imgPlus;
        TextView txtNumber;

        int position;
        int sl;
    }


}
