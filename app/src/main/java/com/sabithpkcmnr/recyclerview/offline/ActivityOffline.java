package com.sabithpkcmnr.recyclerview.offline;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sabithpkcmnr.recyclerview.R;

import java.util.ArrayList;

public class ActivityOffline extends AppCompatActivity {

    //Variable - ArrayList of String characters
    ArrayList<OfflineModel> offlineModelList;

    //Variable - Adapter represented in form of variable
    OfflineAdapter offlineAdapter;

    //Variable - RecyclerView - to dislay list in form of layout
    RecyclerView offlineRecyclerView;

    //Variable - Top progress - not necessary, just to show progress
    SwipeRefreshLayout offlineSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Pointing all variables (linking the java variables with layout widgets)
        offlineSwipe = findViewById(R.id.offlineSwipe);
        offlineRecyclerView = findViewById(R.id.offlineRecyclerView);

        //Disable swipe refresh for our layout
        offlineSwipe.setEnabled(false);
        //Setting custom color for swipe progress
        offlineSwipe.setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary), Color.RED);

        //Displaying list as vertical list (linear) using LayoutManager
        LinearLayoutManager linearMgr = new LinearLayoutManager(this);

        //Adding String elements one by one to the ArrayList
        offlineModelList = loadOfflineDataToRecyclerView();

        //Just pointing the 'offlineAdapter' variable to 'OfflineAdapter' Adapter Class
        offlineAdapter = new OfflineAdapter(offlineModelList);

        //Setting the way of item listing (vertically using LinearLayout)
        offlineRecyclerView.setLayoutManager(linearMgr);
        //Pointing the offlineAdapter to RecyclerView
        offlineRecyclerView.setAdapter(offlineAdapter);

        //To improve list scroll smoothness
        offlineRecyclerView.setNestedScrollingEnabled(false);

        //To improve list scroll smoothness
        offlineRecyclerView.setHasFixedSize(true);

        //Calling the method to add all string data to ArrayList
        loadOfflineDataToRecyclerView();
    }


    //Method to add Strings to ArrayList
    private ArrayList<OfflineModel> loadOfflineDataToRecyclerView() {
        //Configuring the Model Class to ArrayList
        ArrayList<OfflineModel> modelCategories = new ArrayList<>();

        //Running a loop until all the data from StringArray get added to Model Class
        for (int i = 0; i < stringOfflineList.length; i++) {

            //Just creating a variable for OfflineModel class
            OfflineModel offlineModel = new OfflineModel();

            //Adding each String to OfflineModel class using method 'setModelTextView("string value")'
            offlineModel.setListTitle(stringOfflineList[i]);
            modelCategories.add(offlineModel);
        }
        return modelCategories;
    }


    //List of String data to add into ArrayList to Model Class
    public static String stringOfflineList[] = {
            "Offline One",
            "Hello Two",
            "Hey Three",
            "Happy Four",
            "Tech Five",
            "Super Six",
            "Giant Seven",
            "Thrilling Eight",
            "Cool Nine",
            "Warm Ten",
            "Hot Eleven",
            "Sparking Twelve",
            "And Thirteen",
            "Ofcourse Fourteen",
            "Finally End"
    };

    // NA NA NA NA NA NA NA NA NA
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return super.onOptionsItemSelected(item);
        }
        return false;
    }

}