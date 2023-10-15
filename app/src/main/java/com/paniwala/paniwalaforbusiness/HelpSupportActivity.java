package com.paniwala.paniwalaforbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.paniwala.paniwalaforbusiness.databinding.ActivityHelpSupportBinding;

public class HelpSupportActivity extends DrawerBaseActivity {
    ActivityHelpSupportBinding activityHelpSupportBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHelpSupportBinding = ActivityHelpSupportBinding.inflate(getLayoutInflater());
        setContentView(activityHelpSupportBinding.getRoot());
        allocateActivityTitle("HelpSupport");
    }
}