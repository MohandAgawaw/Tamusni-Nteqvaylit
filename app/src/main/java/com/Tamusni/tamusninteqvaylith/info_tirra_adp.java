package com.Tamusni.tamusninteqvaylith;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class info_tirra_adp extends RecyclerView.Adapter<info_tirra_adp.ViewHolder>{
    private static final String TAG = "info_tira_adp";
    private Context mContxte;
    private ArrayList<info_tirra> messagesList;

    public info_tirra_adp(Context mContxte, ArrayList<info_tirra> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_info_tirra,parent,false);
        info_tirra_adp.ViewHolder holder = new info_tirra_adp.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.btn.setVisibility(View.INVISIBLE);
        Glide.with(mContxte).load(messagesList.get(position).Pic1).into(holder.imageView1);
        Glide.with(mContxte).load(messagesList.get(position).Pic2).into(holder.imageView2);
        holder.textViewtitel.setText(messagesList.get(position).getTitel());
        holder.textViewdisci.setText(messagesList.get(position).getDiscri());
        if(!messagesList.get(position).getLink().isEmpty()){
                Uri uri = Uri.parse(messagesList.get(position).getLink());
                holder.videoView.setVideoURI(uri);
                holder.videoView.requestFocus();
                holder.linearLayoutvdo.setVisibility(View.VISIBLE);
                holder.imageplayps.setVisibility(View.VISIBLE);
                holder.btn.setVisibility(View.VISIBLE);
        }else {
            holder.linearLayoutvdo.setVisibility(View.INVISIBLE);
            holder.imageplayps.setVisibility(View.INVISIBLE);
        }

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn.setVisibility(View.INVISIBLE);
                holder.videoView.start();
                holder.imageplayps.setImageResource(R.drawable.ic_baseline_stop_24);
            }
        });
        holder.imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        holder.imageplayps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( holder.videoView.isPlaying()){
                    holder.videoView.pause();
                    holder.btn.setVisibility(View.VISIBLE);
                    holder.imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }else {
                    holder.btn.setVisibility(View.INVISIBLE);
                    holder.videoView.start();
                    holder.imageplayps.setImageResource(R.drawable.ic_baseline_stop_24);

                }
            }
     });
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( holder.videoView.isPlaying()){
                    holder.videoView.pause();
                    holder.btn.setVisibility(View.VISIBLE);
                    holder.imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }else {
                    holder.btn.setVisibility(View.INVISIBLE);
                    holder.videoView.start();
                    holder.imageplayps.setImageResource(R.drawable.ic_baseline_stop_24);

                }
            }
        });
        holder.imageViewest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.videoView.resume();
                holder.videoView.start();
                holder.btn.setVisibility(View.INVISIBLE);
            }
        });


}


    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayoutvdo,linearLayoutimg;
        VideoView videoView;

        ImageView imageView1,imageView2,btn;
        ImageView imageplayps,imageViewest;
        TextView textViewtitel,textViewdisci;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           linearLayoutimg = itemView.findViewById(R.id.lytimg);
           linearLayoutvdo = itemView.findViewById(R.id.lytvdo);
           videoView = itemView.findViewById(R.id.tazeqavd);
            imageplayps = itemView.findViewById(R.id.btnply);
            textViewdisci = itemView.findViewById(R.id.textdt);
            imageViewest = itemView.findViewById(R.id.btnrest);
            textViewtitel = itemView.findViewById(R.id.textViewc);
            imageView1 = itemView.findViewById(R.id.imageViewc);
            imageView2 = itemView.findViewById(R.id.imageViewc2);
            btn = itemView.findViewById(R.id.btnnnply);

        }
    }
}
