package com.Tamusni.tamusninteqvaylith;
import static android.content.Context.CLIPBOARD_SERVICE;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class isadapter extends RecyclerView.Adapter<isadapter.ViewHolder> {
    private static final String TAG = "isadapter";
    private Context mContxte;
    private ArrayList<iseframsg> messagesList;


    public isadapter(Context mContxte, ArrayList<iseframsg> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iseframsg,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textView1.setText(messagesList.get(position).getDescription());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("TextView",holder.textView1.getText().toString());
                clipboardManager.setPrimaryClip(clip);
                Toast.makeText(mContxte,"dayen",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        Button btn;



        public ViewHolder(@NonNull View itemView) {



            super(itemView);
            btn = itemView.findViewById(R.id.btnhn);
            textView1 = itemView.findViewById(R.id.textViewc);

        }
    }
}
