package com.sabithpkcmnr.recyclerview.online;

import java.util.Date;

public class OnlineModel extends OnlineModelExtender {

    public Date timestamp;
    private String listTitle;

    public OnlineModel() {
    }

    public OnlineModel(Date timestamp, String listTitle) {
        this.timestamp = timestamp;
        this.listTitle = listTitle;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }
}
