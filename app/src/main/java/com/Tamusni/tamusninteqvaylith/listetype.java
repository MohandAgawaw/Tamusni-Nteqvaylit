package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;

public class listetype extends RecyclerView.Adapter<listetype.ViewHolder>{
    private static final String TAG = "listetype";
    private Context mContxte;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReferencee;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private ArrayList<listeget> messagesList;
    public listetype(Context mContxte, ArrayList<listeget> messagesList) {
        this.mContxte = mContxte;
        this.messagesList = messagesList;
    }
    @NonNull
    @Override
    public listetype.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listetype,parent,false);
        listetype.ViewHolder holder = new listetype.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull listetype.ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        final listeget stuent = messagesList.get(position);
        Glide.with(mContxte).load(stuent.Urlmimg).into(holder.imageView);
        holder.textView1.setText(messagesList.get(position).getNamechat());
        holder.textVieww.setText(messagesList.get(position).getPrenom());
        holder.btn.setImageResource(R.drawable.coeur);







        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContxte,messagesList.get(position).getNamechat(),Toast.LENGTH_SHORT).show();
            }
        });


        if(messagesList.get(position).getGenr().equals("Amalay")){
            holder.textVieww.setTextColor(Color.parseColor("#007bff"));
            holder.textView1.setTextColor(Color.parseColor("#007bff"));
        }else {
            holder.textVieww.setTextColor(Color.parseColor("#ff009d"));
            holder.textView1.setTextColor(Color.parseColor("#ff009d"));
        }

        databaseReferencee = FirebaseDatabase.getInstance().getReference("student");
        holder.msgimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("msg", "" + 1);
                    databaseReferencee.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(hashMap);

            }
        });

        isLikes(position,holder.btn);
        nrLikes(holder.text,position);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(holder.btn.getTag().equals("Like")){

                            FirebaseDatabase.getInstance().getReference().child("noLIKES").child(messagesList.get(position).getPostid())
                                    .child(firebaseUser.getUid()).removeValue();
                            FirebaseDatabase.getInstance().getReference().child("LIKES").child(messagesList.get(position).getPostid())
                                    .child(firebaseUser.getUid()).setValue(true);
                        Toast.makeText(mContxte, "+1 ❤ ", Toast.LENGTH_SHORT).show();

                }else {
                        Toast.makeText(mContxte, "-1 \uD83D\uDC94", Toast.LENGTH_SHORT).show();
                        FirebaseDatabase.getInstance().getReference().child("LIKES").child(messagesList.get(position).getPostid())
                                .child(firebaseUser.getUid()).removeValue();
                }



            }
        });


    }

    private  void isLikes(int pos, final ImageView ImageButton){
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("LIKES").child(messagesList.get(pos).getPostid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(firebaseUser.getUid()).exists()){
                    ImageButton.setImageResource(R.drawable.coeurpress);
                    ImageButton.setTag("Liked");

                }else {
                    ImageButton.setImageResource(R.drawable.coeur);
                    ImageButton.setTag("Like");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private  void  nrLikes(final TextView liKe,int pos){
        String id = messagesList.get(pos).getPostid();
        firebaseAuth = FirebaseAuth.getInstance();
       DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("student");
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("LIKES")
                .child(id);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                {
                    String nn = (dataSnapshot.getChildrenCount()+"");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("like", "" + nn);
                    databaseReference.child(id).updateChildren(hashMap);
                    liKe.setText(dataSnapshot.getChildrenCount()+"");
                }else {
                    String nn = ("0");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("like", "" + nn);
                    databaseReference.child(id).updateChildren(hashMap);
                    liKe.setText(dataSnapshot.getChildrenCount()+"");
                }


                }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView,btn,msgimg;
        TextView text;
        TextView textView1;
        TextView textVieww;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            text = itemView.findViewById(R.id.txtni);
            textVieww = itemView.findViewById(R.id.chatnamee);
            textView1 = itemView.findViewById(R.id.chatname);
            btn = itemView.findViewById(R.id.btnkr);

            msgimg = itemView.findViewById(R.id.msgimgg);
            imageView = itemView.findViewById(R.id.imgprochats);
        }
    }

}