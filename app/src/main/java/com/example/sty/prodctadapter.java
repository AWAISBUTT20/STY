package com.example.sty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class prodctadapter extends RecyclerView.Adapter<prodctadapter.ViewHolder> {
    List<String> desc;
    List<Integer> product;
    LayoutInflater inflater;

    public prodctadapter(List<String> desc, List<Integer> image, Context context) {
        this.desc = desc;
        this.product = image;
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
        holder.txtdesc.setText(desc.get(position));
        holder.prdct.setImageResource(product.get(position));
    }
    @Override
    public int getItemCount() {
return desc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtdesc;
        ImageView prdct;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtdesc = itemView.findViewById(R.id.textView);
            prdct = itemView.findViewById(R.id.imageView);
        }
    }
}