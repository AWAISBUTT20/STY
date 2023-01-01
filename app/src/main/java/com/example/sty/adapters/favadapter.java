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

public class favadapter extends RecyclerView.Adapter<favadapter.Viewholer> {
    public favadapter() {

    }

    ArrayList<String> prdctname = new ArrayList<>();
    ArrayList<String> prdctdesc = new ArrayList<>();
    ArrayList<String> prdctprice = new ArrayList<>();
    ArrayList<Integer> prdctimg = new ArrayList<>();
    LayoutInflater inflater;

    public favadapter(ArrayList<String> prdctname, ArrayList<String> prdctdesc, ArrayList<String> prdctprice, ArrayList<Integer> prdctimg, Context context) {
        this.prdctname = prdctname;
        this.prdctdesc = prdctdesc;
        this.prdctprice = prdctprice;
        this.prdctimg = prdctimg;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Viewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cartadptr, parent, false);
        return new Viewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholer holder, int position) {
        holder.name.setText(prdctname.get(position));
        holder.desc.setText(prdctdesc.get(position));
        holder.price.setText(prdctprice.get(position));
        holder.img.setImageResource(prdctimg.get(position));
    }

    @Override
    public int getItemCount() {
        return prdctname.size();
    }

    public class Viewholer extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;
        TextView price;
        ImageView img;

        public Viewholer(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cartname);
            desc = itemView.findViewById(R.id.cartdescr);
            price = itemView.findViewById(R.id.cartprice);
            img = itemView.findViewById(R.id.cartimg);

        }
    }
}
