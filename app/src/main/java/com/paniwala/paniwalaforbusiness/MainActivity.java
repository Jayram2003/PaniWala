package com.paniwala.paniwalaforbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView = findViewById(R.id.textView);
        textView.animate().translationX(800).setDuration(800).setStartDelay(1200);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    // To decrease or increase the animation time change it and also focus on setStartDelay
                    Thread.sleep(2000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if (FirebaseUtil.isLoggedIn()) {
                        Intent intent = new Intent(MainActivity.this, Dashboard.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, EnterMobileNumber.class);
                        startActivity(intent);

                    }
                    finish();
                }
            }
        };
        thread.start();
    }
}