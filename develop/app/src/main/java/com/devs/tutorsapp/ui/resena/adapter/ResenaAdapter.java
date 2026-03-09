package com.devs.tutorsapp.ui.resena.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.local.entity.ResenaEntity;
import com.devs.tutorsapp.data.model.ResenaDetalle;

import java.util.ArrayList;
import java.util.List;

public class ResenaAdapter extends RecyclerView.Adapter<ResenaAdapter.ViewHolder> {

    private List<ResenaDetalle> list = new ArrayList<>();

    public void setData(List<ResenaDetalle> data) {
        list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResenaDetalle item = list.get(position);

        holder.tvNomAlu.setText(item.getAlumnoNombre() + " " + item.getAlumnoApellido());
        holder.tvDateRev.setText(item.getFecha());
        holder.tvComment.setText(item.getComentario());

        holder.tvProm.setText(item.getPuntuacion() + " " + getStars((int) item.getPuntuacion()));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    private String getStars(int rating) {
        if (rating <= 0) return "★";

        StringBuilder stars = new StringBuilder();

        for (int i = 0; i < rating; i++) {
            stars.append("★");
        }
        return stars.toString();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomAlu, tvProm, tvComment, tvDateRev;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomAlu = itemView.findViewById(R.id.tvNomAlu);
            tvDateRev = itemView.findViewById(R.id.tvDateRev);
            tvComment = itemView.findViewById(R.id.tvComment);
            tvProm = itemView.findViewById(R.id.tvProm);
        }
    }
}
