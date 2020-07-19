package com.example.wedding;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Kategori> mData;

    public RecyclerViewAdapter(Context mContext, List<Kategori> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater  = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_kategori.setText(mData.get(position).getTitle());
        holder.tv_deskripsi.setText(mData.get(position).getDescription());
        holder.img_kategori.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,KategoriActivity.class);

                //passing data kategori activity
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());

                //start activity
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_kategori ;
        TextView tv_deskripsi;
        ImageView img_kategori;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_kategori = itemView.findViewById(R.id.tv_kategori);
            tv_deskripsi = itemView.findViewById(R.id.tv_deskripsi);
            img_kategori = itemView.findViewById(R.id.img_kategori);
            cardView = itemView.findViewById(R.id.cardview_id);

        }
    }

    
}
