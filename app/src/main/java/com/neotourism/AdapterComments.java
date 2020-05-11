package com.neotourism;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterComments extends RecyclerView.Adapter<AdapterComments.ViewHolder> {

    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mComments = new ArrayList<>();
    private Context mContext;

    public AdapterComments(Context mContext, ArrayList<Integer> mImages, ArrayList<String> mNames, ArrayList<String> mComments) {
        this.mImages = mImages;
        this.mNames = mNames;
        this.mComments = mComments;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comentario,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(mImages.get(position));
        holder.name.setText(mNames.get(position));
        holder.comment.setText(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView comment;
        public ViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.imageComentario);
            name = itemView.findViewById(R.id.nameComment);
            comment = itemView.findViewById(R.id.commentText);
        }
    }
}

