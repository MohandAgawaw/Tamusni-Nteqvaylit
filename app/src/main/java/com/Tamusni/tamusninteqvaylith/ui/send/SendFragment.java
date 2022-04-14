package com.Tamusni.tamusninteqvaylith.ui.send;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.Tamusni.tamusninteqvaylith.Avantcentre;
import com.Tamusni.tamusninteqvaylith.R;


public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;
    EditText titre,awal;
    TextView zzz;
    String ca;
    Button chega;

    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);

        zzz = root.findViewById(R.id.ettoo);
        titre = root.findViewById(R.id.titree);
        ca = "suppot@tamusninteqvaylit.online";
        awal = root.findViewById(R.id.autoCompleteTextView3);
        chega = root.findViewById(R.id.BTN_ar2);
        ImageView img = root.findViewById(R.id.imglogo);

        img.setBackgroundResource(R.drawable.logo1);
        chega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titre.length()==0){
                    Toast.makeText(getActivity(), "Aru Isem-ik (im)", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if(awal.length()==0){
                        Toast.makeText(getActivity(), "Aru Awal-ik (im)", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        sendMail();
                    }

                }


            }
        });

        zzz.setText("suppot@tamusninteqvaylit.online");
        zzz.setTextColor(Color.parseColor("#FFFFFF"));
        titre.setHintTextColor(Color.parseColor("#D8D1D1"));
        titre.setTextColor(Color.parseColor("#FFFFFF"));
        awal.setTextColor(Color.parseColor("#FFFFFF"));
        awal.setHintTextColor(Color.parseColor("#D8D1D1"));
        chega.setTextColor(Color.parseColor("#FFFFFF"));


        final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe( this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);


            }
        });
        return root;


    }

    private void sendMail() {
        String recipientList = ca;
        String[] recipients = recipientList.split(",");
        String subject = titre.getText().toString();
        String message = awal.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }


    @Override
    public void onStart() {

        super.onStart();
    }

    public void onBackPressed() {

        super.onStart();

        startActivity(new Intent(getApplicationContext(), Avantcentre.class));



    }

    private Context getApplicationContext() {

        startActivity(new Intent(getApplicationContext(), Avantcentre.class));
        return null;
    }

}