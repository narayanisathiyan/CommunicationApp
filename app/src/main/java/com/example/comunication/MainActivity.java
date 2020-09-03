package com.example.comunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.editTextTextPersonName3);
        t2=findViewById(R.id.editTextTextPersonName4);
    }

    public void sending(View view) {
        String s1 = t1.getText().toString();
        String s2 = t2.getText().toString();
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(s1,null,s2,null,null);
    }

    public void sendemail(View view) {
        Intent email = new Intent(Intent.ACTION_SEND);


        email.putExtra(Intent.EXTRA_EMAIL,new String[]{"cprateeti@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT,"Absolute Nonsense");
        email.putExtra(Intent.EXTRA_TEXT,"This is madness madness");

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,"Choose an Email client :"));
    }

    public void camera(View view) {
        Intent in = new Intent((MediaStore.ACTION_IMAGE_CAPTURE));
        startActivity(in);
    }

    public void next(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}