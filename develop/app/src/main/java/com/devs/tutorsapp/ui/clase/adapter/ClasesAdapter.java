package com.devs.tutorsapp.ui.clase.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.model.Clase;

import java.util.List;

public class ClasesAdapter extends RecyclerView.Adapter<ClasesAdapter.ViewHolder> {

    private List<Clase> list;

    public ClasesAdapter(List<Clase> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Clase item = list.get(position);

        holder.name.setText(item.getName());
        holder.date.setText(item.getDate());

        if (item.getStatus().equals("pending")) {
            //punto naranja
            holder.statusDot.setBackgroundColor(Color.parseColor("#FF5722"));
        } else if(item.getStatus().equals("confirmed")) {
            //punto verde
            holder.statusDot.setBackgroundColor(Color.parseColor("#0AD02D"));
        } else {
            //punto gris
            holder.statusDot.setBackgroundColor(Color.parseColor("#818181"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, date;
        private View statusDot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            date = itemView.findViewById(R.id.txtDate);
            statusDot = itemView.findViewById(R.id.statusDot);
        }
    }

}
