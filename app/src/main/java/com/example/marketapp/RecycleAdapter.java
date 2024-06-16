package com.example.marketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.myViewHolder> {
    private Context context;
    private List<ItemClass> itemlist;
    private ItemClickListener mylistener;

    public void setOnItemClickListener(ItemClickListener mylistener){
        this.mylistener=mylistener;
    }
    public RecycleAdapter(List<ItemClass> itemlist) {
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_layout,parent,false);
        return new myViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        ItemClass item=itemlist.get(position);
        holder.itemimageholder.setImageResource(item.getItemimage());
        holder.itemnameholder.setText(item.getItemname());
        holder.itemdescholder.setText(item.getItemdesc());
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }


    public  class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemimageholder;
        TextView itemnameholder;
        TextView itemdescholder;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            itemimageholder=itemView.findViewById(R.id.recycleImageView);
            itemnameholder=itemView.findViewById(R.id.textView);
            itemdescholder=itemView.findViewById(R.id.textDescriptionView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(mylistener!= null){
                mylistener.onClick(v,getAdapterPosition());
            }

        }
    }

}
