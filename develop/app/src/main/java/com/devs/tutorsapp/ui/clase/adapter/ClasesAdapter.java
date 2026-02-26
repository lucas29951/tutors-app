package com.devs.tutorsapp.ui.clase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.model.ClaseDetalle;

import java.util.List;

public class ClasesAdapter extends RecyclerView.Adapter<ClasesAdapter.ViewHolder> {

    private List<ClaseDetalle> lista;

    public ClasesAdapter(List<ClaseDetalle> lista) {
        this.lista = lista;
    }

    public ClasesAdapter() {
        this.lista = null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClaseDetalle item = lista.get(position);

        holder.name.setText(item.tutorNombre + " " + item.tutorApellido);
        holder.date.setText(item.materiaNombre + " - " + item.getFecha() + " " + item.getHora_inicio());

        if (item.getEstado().equals("Pending")) {
            holder.statusDot.setBackgroundResource(R.drawable.bg_status_dot_pending);
        } else if(item.getEstado().equals("Confirmed")) {
            holder.statusDot.setBackgroundResource(R.drawable.bg_status_dot_confirmed);
        } else {
            holder.statusDot.setBackgroundResource(R.drawable.bg_status_dot_completed);
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setData(List<ClaseDetalle> lista) {
        this.lista = lista;
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
