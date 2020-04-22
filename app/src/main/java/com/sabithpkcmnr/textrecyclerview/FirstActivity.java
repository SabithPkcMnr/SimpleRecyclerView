package com.sabithpkcmnr.textrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.sabithpkcmnr.textrecyclerview.offline.ActivityOffline;
import com.sabithpkcmnr.textrecyclerview.online.ActivityOnline;

public class FirstActivity extends AppCompatActivity {

    AdView adViewFirstPage;
    Button mainBtOnline, mainBtOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        MobileAds.initialize(this, "ca-app-pub-2348371936988937~3470761361");

        //Show what to ID
        mainBtOnline = findViewById(R.id.mainBtOnline);
        mainBtOffline = findViewById(R.id.mainBtOffline);
        adViewFirstPage = findViewById(R.id.adViewFirstPage);

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


        loadAdViewBanner();
    }

    private void loadAdViewBanner() {
        adViewFirstPage.loadAd(new AdRequest.Builder().build());
    }
}