package com.sabithpkcmnr.textrecyclerview.offline;

import com.sabithpkcmnr.textrecyclerview.online.OnlineModelExtender;

import java.util.Date;

public class OfflineModel extends OnlineModelExtender {

    private String listTitle;

    public OfflineModel() {
    }

    public OfflineModel(String listTitle) {
        this.listTitle = listTitle;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }
}