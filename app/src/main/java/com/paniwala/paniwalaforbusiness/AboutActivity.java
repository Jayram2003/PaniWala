package com.paniwala.paniwalaforbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.paniwala.paniwalaforbusiness.databinding.ActivityAboutBinding;

public class AboutActivity extends DrawerBaseActivity {
    ActivityAboutBinding activityAboutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAboutBinding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(activityAboutBinding.getRoot());
        allocateActivityTitle("About");
    }
}