package com.paniwala.paniwalaforbusiness;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class FirebaseAppInialize extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
