package com.paniwala.paniwalaforbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.paniwala.paniwalaforbusiness.databinding.ActivityDashboardBinding;

public class Dashboard extends DrawerBaseActivity implements View.OnClickListener {

    ActivityDashboardBinding activityDashboardBinding;
    private CardView customers_cardView, payment_cardView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");

        //From here bottom code is started
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        Toast.makeText(Dashboard.this, "This is home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_Message:
                        Toast.makeText(Dashboard.this, "This is Message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notification_bottom:
                        Toast.makeText(Dashboard.this, "This is notification", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



        // from here card view code is started. To open new activity after clicking on card view
        customers_cardView = findViewById(R.id.customer_cardview);
        payment_cardView = findViewById(R.id.payment_cardview);

        customers_cardView.setOnClickListener(this);
        payment_cardView.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()){
            case R.id.customer_cardview:
                intent = new Intent(Dashboard.this,CustomersActivity.class);
                startActivity(intent);
                break;

            case R.id.payment_cardview:
                intent = new Intent(Dashboard.this,PaymentActivity.class);
                startActivity(intent);
                break;
        }

    }
}

