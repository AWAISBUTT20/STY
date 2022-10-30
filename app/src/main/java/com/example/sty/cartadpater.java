package com.example.sty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class cartadpater extends RecyclerView.Adapter<cartadpater.cartVholder> {
    LayoutInflater layoutInflater;
    ArrayList<String> prdctname,prdctdesc,prdctprice;
    ArrayList<Integer> prdctimg;
    //ArrayList<String> prdctvalue;

    public cartadpater(Context context, ArrayList<String> prdctname, ArrayList<String> prdctdesc, ArrayList<String> prdctprice, ArrayList<Integer> prdctimg) {
        this.layoutInflater = LayoutInflater.from(context);
        this.prdctname = prdctname;
        this.prdctdesc = prdctdesc;
        this.prdctprice = prdctprice;
        this.prdctimg = prdctimg;
    }

    @NonNull
    @Override
    public cartVholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.cart,parent,false);
        return new cartVholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cartVholder holder, int position) {
        holder.name.setText(prdctname.get(position));
        holder.desc.setText(prdctdesc.get(position));
        holder.price.setText(prdctprice.get(position));
        holder.img.setImageResource(prdctimg.get(position));
    }
    @Override
    public int getItemCount() {
        return prdctname.size();
    }

    public class cartVholder extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;
        TextView price;
        ImageView img;

        public cartVholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.cartname);
            desc=itemView.findViewById(R.id.cartdescr);
            price=itemView.findViewById(R.id.cartprice);
            img=itemView.findViewById(R.id.cartimg);

        }
    }
}
