package com.devs.tutorsapp.ui.clase.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.model.Clase;

import java.util.List;

public class ClasesAdapter extends RecyclerView.Adapter<ClasesAdapter.ViewHolder> {

    private List<ClaseEntity> list;

    public ClasesAdapter(List<ClaseEntity> list) {
        this.list = list;
    }

    public ClasesAdapter() {
        this.list = null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClaseEntity item = list.get(position);

        holder.name.setText("ID de Tutor: " + item.getTutor_id());
        holder.date.setText(item.getFecha() + " " + item.getHora_inicio());

        if (item.getEstado().equals("Pending")) {
            //punto naranja
            holder.statusDot.setBackgroundColor(Color.parseColor("#FF5722"));
        } else if(item.getEstado().equals("Confirmed")) {
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

    public void setData(List<ClaseEntity> list) {
        this.list = list;
        notifyDataSetChanged();
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
