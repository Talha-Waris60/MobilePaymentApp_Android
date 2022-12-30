package com.codewithtalha.atm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    HistoryFragment context;
    ArrayList<Model> arrContact;
    public RecyclerContactAdapter(HistoryFragment context, ArrayList<Model> arrContact ){
        this.context = context;
        this.arrContact = arrContact;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageContact.setImageResource(arrContact.get(position).img);
        holder.textName.setText(arrContact.get(position).name);
        holder.textDate.setText(arrContact.get(position).date);
        holder.textAmount.setText(arrContact.get(position).amount);
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textName,textDate, textAmount;
        ImageView imageContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textName =itemView.findViewById(R.id.personName);
            textDate = itemView.findViewById(R.id.date);
            textAmount = itemView.findViewById(R.id.price);
            imageContact = itemView.findViewById(R.id.contactImg);
        }
    }

}
