package com.sabithpkcmnr.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sabithpkcmnr.recyclerview.offline.ActivityOffline;
import com.sabithpkcmnr.recyclerview.online.ActivityOnline;

public class FirstActivity extends AppCompatActivity {

    Button mainBtOnline, mainBtOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //Show what to ID
        mainBtOnline = findViewById(R.id.mainBtOnline);
        mainBtOffline = findViewById(R.id.mainBtOffline);

        mainBtOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, ActivityOnline.class));
            }
        });

        mainBtOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, ActivityOffline.class));
            }
        });
    }

}