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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    ArrayList<String> kasvinimi;

    Context ctx;

    public CustomAdapter(ArrayList<String> kasvinimi, Context ctx) {
        this.kasvinimi = kasvinimi;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listaan, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.kasvi.setText(kasvinimi.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, kasvinimi.get(position), Toast.LENGTH_SHORT).show();
            }
        }
        );
    }

    @Override
    public int getItemCount() {
        return kasvinimi.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView kasvi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            kasvi = itemView.findViewById(R.id.kasvi);
        }
    }
}
