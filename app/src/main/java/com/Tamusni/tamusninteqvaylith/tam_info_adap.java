package com.Tamusni.tamusninteqvaylith;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class tam_info_adap extends RecyclerView.Adapter<tam_info_adap.ViewHolder> {

    private static final String TAG = "tam_info_adap";
    private Context mContxte;
    private ArrayList<tam_info>  messagesList;

    public tam_info_adap(Context mContxte, ArrayList<tam_info> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }


    @NonNull
    @Override
    public tam_info_adap.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tam_info,parent,false);
        tam_info_adap.ViewHolder holder = new tam_info_adap.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") final int position) {
        holder.textView.setText(messagesList.get(position).getDescription());
        holder.textView1.setText(messagesList.get(position).getDate());
        Glide.with(mContxte)
                .load(messagesList.get(position).getUrlmimg())
                .into(holder.imageView);

    }




    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView1;



        public ViewHolder(@NonNull View itemView) {



            super(itemView);
            textView1 = itemView.findViewById(R.id.textViewc);
            textView = itemView.findViewById(R.id.textdt);
            imageView = itemView.findViewById(R.id.imageViewc);
        }
    }
}
