package com.devs.tutorsapp.ui.tutor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.tutorsapp.R;
import com.devs.tutorsapp.data.local.entity.TutorEntity;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {

    private List<TutorEntity> tutorList;
    private OnTutorClickListener listener;

    public TutorAdapter(List<TutorEntity> tutorList, OnTutorClickListener listener) {
        this.tutorList = tutorList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TutorAdapter.TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutor, parent, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorAdapter.TutorViewHolder holder, int position) {
        TutorEntity tutor = tutorList.get(position);

        holder.nombre.setText(tutor.getNombre() + " " + tutor.getApellido());
        holder.descripcion.setText(tutor.getDescripcion());
        holder.precio.setText("$ " + tutor.getPrecio() + "/h");

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onTutorClick(tutor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tutorList != null ? tutorList.size() : 0;
    }

    public void setTutorList(List<TutorEntity> tutorList) {
        if (tutorList != null) {
            this.tutorList = tutorList;
            notifyDataSetChanged();
        }
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, descripcion, precio;

        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.textNombre);
            descripcion = itemView.findViewById(R.id.textDescripcion);
            precio = itemView.findViewById(R.id.textPrecio);
        }
    }

    public interface OnTutorClickListener {
        void onTutorClick(TutorEntity tutor);
    }

}
