package com.Tamusni.tamusninteqvaylith.ui.home;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.Tamusni.tamusninteqvaylith.Avantcentre;
import com.Tamusni.tamusninteqvaylith.R;
import com.Tamusni.tamusninteqvaylith.modefie;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {
    private int STORAGE_PERMISSION_CODE = 1;
    FirebaseUser Userr;
    private String myUri = "";
    private StorageTask uploadTask;

ImageView imgpro;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button changee;
    SwipeButton mdf;
    TextView NomeTV,PrenomTV,Text_home,txtinfo;
    private Uri mImageUri;
    private CircleImageView ProfileImage;
String genregar = "Amalay"
        ,genrefi = "Unti" ;
    private DatabaseReference Myref;
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    FirebaseStorage firebaseStorage;
    private static final int PICK_IMAGE = 1;

    ProgressDialog progressDialog,progressDialogg;
    ProgressBar progressBar2;
    private  final  int Time_Slash = 1500;
    public WebView wbv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View root = inflater.inflate(R.layout.fragment_home, container, false);

        NomeTV = root.findViewById(R.id.Nomee);
        imgpro = root.findViewById(R.id.imgpro);
        PrenomTV = root.findViewById(R.id.disci);
        Text_home = root.findViewById(R.id.text_home);
        txtinfo = root.findViewById(R.id.textinfou);
        ProfileImage = root.findViewById(R.id.usrimg);
        Myref = FirebaseDatabase.getInstance().getReference();
        changee = root.findViewById(R.id.changee);
        progressBar2 = root.findViewById(R.id.progressBar2);
        mdf = root.findViewById(R.id.mdf);
        wbv = root.findViewById(R.id.Webviehom);


        Query query = Myref.child("studinfo");
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String texteinfo = " " + dataSnapshot.child("post1").child("texte").getValue().toString();
                    String image1 = dataSnapshot.child("post1").child("pic").getValue().toString();
                    txtinfo.setText(texteinfo);
                    Picasso.get().load(image1).into(imgpro);
                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        WebSettings webSettings = wbv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()|| !networkInfo.isAvailable()){
            dialogg();

        }else {
            dialog();
        }


        progressBar2.setVisibility(View.VISIBLE);

        mdf.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                startActivity(new Intent(getActivity().getApplicationContext(), modefie.class));
            }
        });

        changee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {


                    PICK();
                    Intent gallery = new Intent();
                    gallery.setType("image/*");
                    gallery.setAction(Intent.ACTION_GET_CONTENT);

                    startActivityForResult(Intent.createChooser(gallery, "Sellect Picture"), PICK_IMAGE);
                } else {
                    requestStoragePermission();
                }
            }

            private void requestStoragePermission() {

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission needed")
                            .setMessage("This permission is needed because of this and that")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(getActivity(),
                                            new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create().show();
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                }


            }


        });

        firebaseAuth = FirebaseAuth.getInstance();
        Userr = firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference().child("usr");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("student");
        getUserinfo();


        return root;




    }


        private void getUserinfo() {

            databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0)
                    {
                        String Name = " " + dataSnapshot.child("nom").getValue().toString();
                        String Email = "Tirwat : "+ dataSnapshot.child("email").getValue().toString();
                        String Prenom = " " + dataSnapshot.child("prenom").getValue().toString();
                        String genre = dataSnapshot.child("gender").getValue().toString();
                        String imagee = dataSnapshot.child("image").getValue().toString();


                        NomeTV.setText(Name);
                        PrenomTV.setText(Prenom);
                        Text_home.setText(Email);



                        if (genre.equals(genregar)){
                            NomeTV.setTextColor(Color.parseColor("#007bff"));
                            PrenomTV.setTextColor(Color.parseColor("#007bff"));
                        } else if (genre.equals(genrefi)){
                            NomeTV.setTextColor(Color.parseColor("#ff009d"));
                            PrenomTV.setTextColor(Color.parseColor("#ff009d"));
                        }
                        if(!imagee.equals("null")){

                            if (dataSnapshot.hasChild("image")) {
                                String image = dataSnapshot.child("image").getValue().toString();

                                try {
                                    Picasso.get().load(image).into(ProfileImage);
                                    progressBar2.setVisibility(View.INVISIBLE);
                                } catch (Exception e) {

                                    Picasso.get().load(R.drawable.user).into(ProfileImage);
                                    progressBar2.setVisibility(View.INVISIBLE);

                                }
                            }

                        }else {
                            progressBar2.setVisibility(View.INVISIBLE);
                        }

                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
    }

    private void dialogg() {
        progressDialogg = new ProgressDialog(getContext());
        progressDialogg.show();
        progressDialogg.setContentView(R.layout.activity_alertediaa);
        progressDialogg.setCancelable(false);
        progressDialogg.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
        Button btnrt = progressDialogg.findViewById(R.id.btnrtr);
        btnrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), Avantcentre.class));
                getActivity().finish();
            }
        });
    }


    private void dialog() {

        progressDialog = new ProgressDialog(getContext());
        progressDialog.show();
        progressDialog.setContentView(R.layout.dialog);

        progressDialog.getWindow().setBackgroundDrawableResource(

                android.R.color.transparent
        );

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressDialog.hide();
            }
        };
        new Handler().postDelayed(runnable,Time_Slash);

    }

    private void PICK() {



    }

    public void onBackPressed() {

        super.onStart();

        startActivity(new Intent(getApplicationContext(), Avantcentre.class));
        getActivity().finish();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {

            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(ProfileImage);
            progressBar2.setVisibility(View.VISIBLE);
            uploadFile(mImageUri);
        }
    }

    private void uploadFile(Uri mImageUri) {
         if (mImageUri != null)
        {
            final StorageReference fileRef = storageReference
                    .child(firebaseAuth.getCurrentUser().getUid()+ ".jpg");

            uploadTask = fileRef.putFile(mImageUri);
            progressBar2.setVisibility(View.VISIBLE);

            uploadTask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful())
                    {
                        throw task.getException();
                    }
                    return fileRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful())
                    {

                        Uri downloadUrl =task.getResult();
                        myUri = downloadUrl.toString();

                        HashMap<String, Object> userMap = new HashMap<>();
                        userMap.put("image",myUri);
                        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).updateChildren(userMap);
                        progressBar2.setVisibility(View.INVISIBLE);


                        Toast.makeText(getContext(), "Dayen Tulli", Toast.LENGTH_SHORT).show();


                    }


                }
            });
        }
        else {
            Toast.makeText(getContext(), "Data update", Toast.LENGTH_SHORT).show();
        }
    }




    private Context getApplicationContext() {

        startActivity(new Intent(getActivity().getApplicationContext(), Avantcentre.class));
        return null;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "Permission GRANTED", Toast.LENGTH_SHORT).show();
                PICK();
            } else {
                Toast.makeText(getContext(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


}