package com.Tamusni.tamusninteqvaylith;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class tam_info_vdofto_adp extends RecyclerView.Adapter<tam_info_vdofto_adp.ViewHolder>{
    private static final String TAG = "tam_info_adap";
    private Context mContxte;
    private ArrayList<tam_info_vdofto> messagesList;

    public tam_info_vdofto_adp(Context mContxte, ArrayList<tam_info_vdofto> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public tam_info_vdofto_adp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tam_info_vdofto,parent,false);
        tam_info_vdofto_adp.ViewHolder holder = new tam_info_vdofto_adp.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull tam_info_vdofto_adp.ViewHolder holder, int position) {
        holder.textView.setText(messagesList.get(position).getDescription());
        holder.textView1.setText(messagesList.get(position).getDate());
        Glide.with(mContxte)
                .load(messagesList.get(position).getUrlmimg())
                .into(holder.imageView);
        if(TextUtils.isEmpty(messagesList.get(position).getLink())){
            holder.youTubePlayerView.setVisibility(View.INVISIBLE);
        }else {
            String txt = messagesList.get(position).getLink();
            holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    youTubePlayer.cueVideo(txt,0);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView1;
        YouTubePlayerView youTubePlayerView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
            textView1 = itemView.findViewById(R.id.textViewc);
            textView = itemView.findViewById(R.id.textdt);
            imageView = itemView.findViewById(R.id.imageViewc);
        }
    }
}
