package com.plantsit.koskaistutan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterMain extends RecyclerView.Adapter<CustomAdapterMain.MyViewHolder> {

    ArrayList<String> kasviNimet;
    ArrayList<String> kasvuAlue;

    Context ctx;

    public CustomAdapterMain(ArrayList<String> kasviNimet, ArrayList<String> kasvuAlue, Context ctx) {

        this.kasviNimet = kasviNimet;
        this.kasvuAlue = kasvuAlue;
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kasvi_lista, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.kasvit.setText(kasviNimet.get(position));
        holder.alue.setText(kasvuAlue.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ctx, kasviNimet.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return kasviNimet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView kasvit, alue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            kasvit = itemView.findViewById(R.id.kasvit);
            alue = itemView.findViewById(R.id.alue);

        }
    }
}
