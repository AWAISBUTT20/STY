package com.example.sty.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sty.R;

import java.util.ArrayList;
import java.util.List;

public class prodctadapter extends RecyclerView.Adapter<prodctadapter.ViewHolder> {
    List<Integer> product;
    LayoutInflater inflater;
    List<String> prdctname;
    List<String> prdctdesc;
    List<String> prdctprice;

    public prodctadapter(Context context, ArrayList<String> prdctname, ArrayList<String> prdctdesc, ArrayList<String> prdctprice, ArrayList<Integer> prdctimg) {
        this.prdctname = prdctname;
        this.prdctdesc = prdctdesc;
        this.prdctprice = prdctprice;
        this.product = prdctimg;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(prdctname.get(position));
        holder.desc.setText(prdctdesc.get(position));
        holder.price.setText(prdctprice.get(position));
        holder.prdct.setImageResource(product.get(position));
    }

    @Override
    public int getItemCount() {
        return prdctname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView prdct;
        TextView name;
        TextView desc;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.prdctname);
            desc = itemView.findViewById(R.id.prdctdesc);
            price = itemView.findViewById(R.id.prdctprice);
            prdct = itemView.findViewById(R.id.prdctimg);
        }
    }
}