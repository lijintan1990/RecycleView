package com.example.administrator.cycleviewtest;


import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private List<Cat> mCat;
    CatAdapter(List<Cat> cat) {
        mCat = cat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.catImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Cat cat = mCat.get(position);
                Toast.makeText(view.getContext(), cat.getname(), Toast.LENGTH_SHORT).show();
            }
        });

        //响应整个item
        holder.catView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Cat cat = mCat.get(position);
                Toast.makeText(view.getContext(), "you click view "+cat.getname(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cat cat = mCat.get(position);
        holder.catImage.setImageResource(cat.getImageid());
        //holder.catImage.setImageBitmap();
        holder.catText.setText(cat.getname());
    }

    @Override
    public int getItemCount() {
        return mCat.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View catView;
        ImageView catImage;
        TextView catText;
        public ViewHolder(View itemView) {
            super(itemView);
            catView = itemView;
            catImage = itemView.findViewById(R.id.cat_image);
            catText = itemView.findViewById(R.id.cat_name);
        }
    }
}