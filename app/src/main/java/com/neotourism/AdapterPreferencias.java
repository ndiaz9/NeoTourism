package com.neotourism;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.neotourism.FragmentIntereses;
import java.util.ArrayList;

public class AdapterPreferencias extends RecyclerView.Adapter<AdapterPreferencias.ViewHolder> {

    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mPreferencias = new ArrayList<>();
    private Context mContext;

    public AdapterPreferencias(Context mContext, ArrayList<Integer> mImages, ArrayList<String> mPreferencias) {
        this.mImages = mImages;
        this.mPreferencias = mPreferencias;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.img.setImageResource(mImages.get(position));
        holder.preferencia.setText(mPreferencias.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cardView.getCardBackgroundColor().getDefaultColor() == mContext.getResources().getColor(R.color.lightBlue)){
                    holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.darkBlue));
                }else{
                    holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.lightBlue));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPreferencias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView preferencia;
        CardView cardView;
        public ViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.imagePreferencia);
            preferencia = itemView.findViewById(R.id.textPreferencia);
            cardView = itemView.findViewById(R.id.cardPref);
        }
    }
}

