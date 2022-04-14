package com.Tamusni.tamusninteqvaylith;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private static final String TAG = "Adapter";
    private Context mContxte;
    private ArrayList<messages> messagesList;


    public Adapter(Context mContxte, ArrayList<messages> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }




    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messagess,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        viewHolder.date.setText(messagesList.get(position).getDate());
        viewHolder.textView.setText(messagesList.get(position).getDescription());

        Glide.with(mContxte)
                .load(messagesList.get(position).Urlmimg)
                .into(viewHolder.imageView);
        viewHolder.btntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(messagesList.get(position).Urlmimg);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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
