package com.Tamusni.tamusninteqvaylith;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recyclisefraadp extends RecyclerView.Adapter<recyclisefraadp.ViewHolder>{

    private static final String TAG = "recyclisefraadp";
    private Context mContxte;
    private ArrayList<recycleisefra> messagesList;
    public recyclisefraadp(Context mContxte, ArrayList<recycleisefra> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycleisefra,parent,false);
        recyclisefraadp.ViewHolder holder = new recyclisefraadp.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(messagesList.get(position).getDate());

        Glide.with(mContxte)
                .load(messagesList.get(position).getUrlmimg())
                .into(holder.btn);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent (view.getContext(),isefranv.class);
                intent.putExtra("ise", messagesList.get(position).getDate());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
       ImageView btn;
        TextView textView1;



        public ViewHolder(@NonNull View itemView) {



            super(itemView);
            textView1 = itemView.findViewById(R.id.isfraname);
           btn = itemView.findViewById(R.id.tarwa);
        }
    }
}

