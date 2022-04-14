package com.Tamusni.tamusninteqvaylith;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class sbe3 extends AppCompatActivity {
    ImageView img1,img2,img3,btnuhu,btnih;
    TextView titel,histoire,likestmm,likestmm1;
    LinearLayout linearLayout;
    String postid = "Poste 6" ;
    private ImageView imageplayps;
    private TextView timecu,timedur;
    private SeekBar playseek;
    private MediaPlayer mediaPlayer;
    LinearLayout lnrvcl;
    private final Handler handler = new Handler();
    private DatabaseReference Myref;

    final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbe3);
        img1 = findViewById(R.id.imagetam1);
        img2 = findViewById(R.id.imagetam2);
        img3 = findViewById(R.id.imagetam3);
        titel = findViewById(R.id.txttitre);
        histoire = findViewById(R.id.histoire);
        Myref = FirebaseDatabase.getInstance().getReference();
        btnih = findViewById(R.id.btnih);
        btnuhu = findViewById(R.id.btnuhu);
        likestmm = findViewById(R.id.likestm);
        likestmm1 = findViewById(R.id.likestm2);
        linearLayout = findViewById(R.id.jame);
        linearLayout.setVisibility(View.INVISIBLE);
        imageplayps = findViewById(R.id.btnply);
        timecu = findViewById(R.id.txttimecu);
        timedur = findViewById(R.id.timedur);
        playseek = findViewById(R.id.seekbarid);
        lnrvcl = findViewById(R.id.lnrvcl);
        mediaPlayer = new MediaPlayer();
        playseek.setMax(100);
        linearLayout.setVisibility(View.INVISIBLE);
        imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        imageplayps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    imageplayps.setImageResource(R.drawable.ic_baseline_play_arrow_24);

                }else {
                    mediaPlayer.start();
                    imageplayps.setImageResource(R.drawable.ic_baseline_stop_24);
                    updatseek();
                }
            }
        });
        preparemediaplyr();
        playseek.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SeekBar seekBar = (SeekBar) view;
                int playpstn = (mediaPlayer.getDuration() / 100) * seekBar.getProgress();
                mediaPlayer.seekTo(playpstn);
                timecu.setText(milliscd(mediaPlayer.getCurrentPosition()));

                return false;
            }
        });

        lnrvcl.setVisibility(View.INVISIBLE);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putInt("possition", mediaPlayer.getCurrentPosition());
        mediaPlayer.pause();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        int pos = savedInstanceState.getInt("possition");
        mediaPlayer.seekTo(pos);
        super.onRestoreInstanceState(savedInstanceState);
    }


    private void preparemediaplyr(){
        Query query = Myref.child("timucuha").child("post6");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = "" + dataSnapshot.child("vocal").getValue().toString();
                    if(texteinfo != ""){
                        try {
                            lnrvcl.setVisibility(View.VISIBLE);
                            mediaPlayer.setDataSource(texteinfo);
                            mediaPlayer.prepare();
                            timedur.setText(milliscd(mediaPlayer.getDuration()));
                        } catch (Exception exception) {

                        }

                    }else {
                        lnrvcl.setVisibility(View.INVISIBLE);

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private  Runnable updater = new Runnable() {
        @Override
        public void run() {
            updatseek();
            long currentduration = mediaPlayer.getCurrentPosition();
            timecu.setText(milliscd(currentduration));
        }
    };
    private  void  updatseek(){
        if(mediaPlayer.isPlaying()){
            playseek.setProgress((int)(((float)mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration())* 100));
            handler.postDelayed(updater,1000);
        }
    }
    private String milliscd(long milliscd){
        String timerStr = "";
        String scnd;
        int hour = (int)(milliscd/(1000 * 60 * 60));
        int minutes = (int)(milliscd % (1000 * 60 * 60))/(1000 * 60);
        int seconds = (int)((milliscd % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (hour > 0) {
            timerStr= hour + ":";
        }
        if (seconds<10){
            scnd = "0"+ seconds;
        }else{
            scnd = "" + seconds;
        }
        timerStr = timerStr + minutes + ":"+scnd;
        return timerStr;
    }


    private  void isLikes(String postid, final ImageView ImageButton){
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("LIKES").child(postid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(firebaseUser.getUid()).exists()){
                    ImageButton.setImageResource(R.drawable.ic_liked);
                    ImageButton.setTag("Liked");
                }else {
                    ImageButton.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                    ImageButton.setTag("Like");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private  void isnoLikes(String postid, final ImageView ImageButton){
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("noLIKES").child(postid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(firebaseUser.getUid()).exists()){
                    ImageButton.setImageResource(R.drawable.ic_pas);
                    ImageButton.setTag("noLiked");
                }else {
                    ImageButton.setImageResource(R.drawable.ic_pasnul);
                    ImageButton.setTag("noLike");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private  void  nrLikes(final TextView liKe,String postid){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("LIKES")
                .child(postid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                liKe.setText(dataSnapshot.getChildrenCount()+" ");
                FirebaseDatabase.getInstance().getReference().child("timucuha").child("post6").child("like")
                        .setValue(dataSnapshot.getChildrenCount()+"");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private  void  nonrLikes(final TextView liKe,String postid){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("noLIKES")
                .child(postid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                liKe.setText(dataSnapshot.getChildrenCount()+" ");
                FirebaseDatabase.getInstance().getReference().child("timucuha").child("post6").child("dislike")
                        .setValue(dataSnapshot.getChildrenCount()+"");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    protected void onStart() {
        super.onStart();
        isnoLikes(postid,btnuhu);
        isLikes(postid,btnih);
        nrLikes(likestmm,postid);
        nonrLikes(likestmm1,postid);
        btnih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnih.getTag().equals("Like")){
                    if(btnuhu.getTag().equals("noLiked")){
                        FirebaseDatabase.getInstance().getReference().child("noLIKES").child(postid)
                                .child(firebaseUser.getUid()).removeValue();
                        FirebaseDatabase.getInstance().getReference().child("LIKES").child(postid)
                                .child(firebaseUser.getUid()).setValue(true);
                        Toast.makeText(sbe3.this, "Tanmirt \uD83E\uDD70", Toast.LENGTH_SHORT).show();
                    }else {
                        FirebaseDatabase.getInstance().getReference().child("LIKES").child(postid)
                                .child(firebaseUser.getUid()).setValue(true);
                        Toast.makeText(sbe3.this, "Tanmirt \uD83E\uDD70", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(sbe3.this, "Tanmirt \uD83D\uDE22", Toast.LENGTH_SHORT).show();
                    FirebaseDatabase.getInstance().getReference().child("LIKES").child(postid)
                            .child(firebaseUser.getUid()).removeValue();
                }
            }
        });
        btnuhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnuhu.getTag().equals("noLike")){
                    if(btnih.getTag().equals("Liked")){
                        Toast.makeText(sbe3.this, "Tanmirt \uD83D\uDE22", Toast.LENGTH_SHORT).show();
                        FirebaseDatabase.getInstance().getReference().child("LIKES").child(postid)
                                .child(firebaseUser.getUid()).removeValue();
                        FirebaseDatabase.getInstance().getReference().child("noLIKES").child(postid)
                                .child(firebaseUser.getUid()).setValue(true);
                    }else {
                        Toast.makeText(sbe3.this, "Tanmirt \uD83D\uDE22", Toast.LENGTH_SHORT).show();
                        FirebaseDatabase.getInstance().getReference().child("noLIKES").child(postid)
                                .child(firebaseUser.getUid()).setValue(true);
                    }


                }else {
                    Toast.makeText(sbe3.this, "Tanmirt \uD83E\uDD70", Toast.LENGTH_SHORT).show();
                    FirebaseDatabase.getInstance().getReference().child("noLIKES").child(postid)
                            .child(firebaseUser.getUid()).removeValue();
                }
            }
        });

        Query query = Myref.child("timucuha");
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String titell = " " + dataSnapshot.child("post6").child("name6").getValue().toString();
                    String hi = " " + dataSnapshot.child("post6").child("hi").getValue().toString();
                    String image1 = dataSnapshot.child("post6").child("pic1").getValue().toString();
                    String image2 = dataSnapshot.child("post6").child("pic2").getValue().toString();
                    String image3 = dataSnapshot.child("post6").child("pic3").getValue().toString();
                    titel.setText(titell);
                    histoire.setText(hi);
                    linearLayout.setVisibility(View.VISIBLE);
                    Picasso.get().load(image1).into(img1);
                    Picasso.get().load(image2).into(img2);
                    Picasso.get().load(image3).into(img3);

                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    @Override

    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}