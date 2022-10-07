package com.sgtech.learncppbasic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<DataHolder> list;
    int i = 0;

    public RecyclerAdapter(Context context, List<DataHolder> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id_Name.setText(list.get(position).Id_Name);
        holder.layout.setOnClickListener(v -> {
            Intent intent = new Intent(context, IntroductionActivity.class);
            intent.putExtra("title", list.get(position).getId_Name());
            intent.putExtra("String", list.get(position).getId_Url());
            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_Name;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            id_Name = itemView.findViewById(R.id.id_Name);
        }
    }
}
