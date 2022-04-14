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

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHolder> {

    private static final String TAG = "Adapterr";
    private Context mContxte;
    private ArrayList<chatss>  messagesList;
    public Adapterr(Context mContxte, ArrayList<chatss> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatmsg,parent,false);
        Adapterr.ViewHolder holder = new Adapterr.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textView.setText(messagesList.get(position).getDescription());
        holder.textView1.setText(messagesList.get(position).getNamechat());
        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(mContxte,messagesList.get(position).getNamechat(),Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(mContxte)
                .load(messagesList.get(position).Urlmimg)
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
            textView1 = itemView.findViewById(R.id.chatname);
            textView = itemView.findViewById(R.id.chatsmsG);
            imageView = itemView.findViewById(R.id.imgprochats);
        }
    }
}
