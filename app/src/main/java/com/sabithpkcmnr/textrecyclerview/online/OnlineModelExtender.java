package com.sabithpkcmnr.textrecyclerview.online;

import androidx.annotation.NonNull;
import com.google.firebase.firestore.Exclude;

@SuppressWarnings("ALL")
public class OnlineModelExtender {

    @Exclude
    public String OnlineModelExtender;

    public <T extends OnlineModelExtender> T withId(@NonNull final String id) {
        this.OnlineModelExtender = id;
        return (T) this;
    }
}