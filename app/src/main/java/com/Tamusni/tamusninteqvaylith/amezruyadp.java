package com.Tamusni.tamusninteqvaylith;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class amezruyadp extends RecyclerView.Adapter<amezruyadp.ViewHolder>{
    private static final String TAG = "amezruyadp";
    private Context mContxte;
    private ArrayList<tam_info_amzruy> messagesList;
    public amezruyadp(Context mContxte, ArrayList<tam_info_amzruy> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public amezruyadp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tam_info_amezruy,parent,false);
        amezruyadp.ViewHolder holder = new amezruyadp.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull amezruyadp.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.date.setText(messagesList.get(position).getDate());
        holder.textView.setText(messagesList.get(position).getDescription());


        Glide.with(mContxte)
                .load(messagesList.get(position).Urlmimg)
                .into(holder.imageView);
        holder.btntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (v.getContext(),tam_amezruy_videcase.class);
                intent.putExtra("number2", messagesList.get(position).getDescription());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,date;
        Button btntel;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            btntel = itemView.findViewById(R.id.btndw);
            imageView = itemView.findViewById(R.id.usrimg);
            textView = itemView.findViewById(R.id.disci);
            imageView = itemView.findViewById(R.id.imageViewc);
            textView = itemView.findViewById(R.id.textViewc);
            date = itemView.findViewById(R.id.textdt);


        }
    }

}
