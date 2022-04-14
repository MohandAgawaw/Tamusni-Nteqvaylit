package com.Tamusni.tamusninteqvaylith;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class tam_info_dbl_adp  extends RecyclerView.Adapter<tam_info_dbl_adp.ViewHolder> {
    private static final String TAG = "tam_info_dbl_adap";
    private Context mContxte;
    private ArrayList<tam_info_dbl> messagesList;


    public tam_info_dbl_adp(Context mContxte, ArrayList<tam_info_dbl> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public tam_info_dbl_adp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tam_info_dbl,parent,false);
        tam_info_dbl_adp.ViewHolder holder = new tam_info_dbl_adp.ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull tam_info_dbl_adp.ViewHolder holder, int position) {
        holder.textView.setText(messagesList.get(position).getDescription());
        holder.textView1.setText(messagesList.get(position).getDate());
        Glide.with(mContxte)
                .load(messagesList.get(position).getUrlmimg())
                .into(holder.imageView);
        Glide.with(mContxte)
                .load(messagesList.get(position).getUrlmimgg())
                .into(holder.imageView1);
    }









    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView,imageView1;
        TextView textView;
        TextView textView1;



        public ViewHolder(@NonNull View itemView) {



            super(itemView);
            textView1 = itemView.findViewById(R.id.textViewc);
            textView = itemView.findViewById(R.id.textdt);
            imageView = itemView.findViewById(R.id.imageViewc);
            imageView1 = itemView.findViewById(R.id.imageViewc2);
        }
    }

}
