package com.neotourism;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener {

    ArrayList<Dato> listDatos;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<Dato> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);

        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        Dato item = listDatos.get(position);
        holder.name.setText(item.getNombre());
        holder.distance.setText(item.getDistancia() + " mts");
        String tags = item.getTags().get(0);
        for (int i = 1; i < item.getTags().size(); i++) {
            tags += ", " + item.getTags().get(i);
        }
        holder.tags.setText(tags);
        holder.placeIcon.setImageResource(item.getFoto());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView name;
        TextView distance;
        TextView tags;
        ImageView placeIcon;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.idPlaceName);
            distance = itemView.findViewById(R.id.idDistance);
            tags = itemView.findViewById(R.id.idTags);
            placeIcon = itemView.findViewById(R.id.idPlaceIcon);
        }

    }
}
