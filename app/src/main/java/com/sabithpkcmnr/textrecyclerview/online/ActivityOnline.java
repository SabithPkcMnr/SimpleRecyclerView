package com.sabithpkcmnr.textrecyclerview.online;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.sabithpkcmnr.textrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityOnline extends AppCompatActivity {

    AlertDialog alertHowTo;

    ArrayList<OnlineModel> onlineModelList;
    OnlineAdapter onlineAdapter;
    RecyclerView onlineRecyclerView;
    SwipeRefreshLayout onlineSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        onlineModelList = new ArrayList<>();

        onlineSwipe = findViewById(R.id.onlineSwipe);
        onlineRecyclerView = findViewById(R.id.onlineRecyclerView);

        onlineSwipe.setEnabled(false);
        onlineSwipe.setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary), Color.RED);

        onlineAdapter = new OnlineAdapter(onlineModelList);

        LinearLayoutManager linearMgr = new LinearLayoutManager(this);

        onlineRecyclerView.setLayoutManager(linearMgr);
        onlineRecyclerView.setHasFixedSize(true);
        onlineRecyclerView.setNestedScrollingEnabled(false);
        onlineRecyclerView.setAdapter(onlineAdapter);

        loadTextsFromFirebase();

        loadInterstitialAd();

        showInfoAlert();
    }

    private void loadInterstitialAd() {
        final InterstitialAd myInter = new InterstitialAd(this);
        myInter.setAdUnitId("ca-app-pub-xxx837xxx6988xxx/xx33534xxx");
        if (myInter.isLoaded()) {
            myInter.show();
        } else {
            myInter.loadAd(new AdRequest.Builder().build());
        }
        myInter.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                myInter.show();
            }
        });
    }

    private void loadTextsFromFirebase() {
        onlineSwipe.setRefreshing(true);

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        Query firstQuery = firebaseFirestore.collection("OnlineList").orderBy("timestamp", Query.Direction.DESCENDING);

        firstQuery.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {

                    String stringTextID = documentChange.getDocument().getId();
                    if (documentChange.getType() == DocumentChange.Type.ADDED) {
                        OnlineModel onlineModel = documentChange.getDocument().toObject(OnlineModel.class).withId(stringTextID);
                        onlineModelList.add(onlineModel);
                    }

                    onlineAdapter.notifyDataSetChanged();
                    onlineSwipe.setRefreshing(false);

                    loadInterstitialAd();
                }
            }
        });
    }


    private void showInfoAlert() {
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") final View alertLayout = inflater.inflate(R.layout.alert_information, null);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(true);

        Button closeBt = alertLayout.findViewById(R.id.alertInfo_bt);
        closeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertHowTo.dismiss();
            }
        });

        alertHowTo = alert.create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_online, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();

        } else if (item.getItemId() == R.id.menu_how_info) {
            alertHowTo.show();
        }
        return super.onOptionsItemSelected(item);
    }
}