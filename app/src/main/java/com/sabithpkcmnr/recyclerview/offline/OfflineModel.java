package com.sabithpkcmnr.recyclerview.offline;

import com.sabithpkcmnr.recyclerview.online.OnlineModelExtender;

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