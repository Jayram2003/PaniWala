package com.paniwala.paniwalaforbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class EnterMobileNumber extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendotpbtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_mobile_number);

        countryCodePicker = findViewById(R.id.login_countrycode);
        phoneInput = findViewById(R.id.login_mobilenumber);
        sendotpbtn = findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);
        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneInput);

      sendotpbtn.setOnClickListener((v)->{
          if(!countryCodePicker.isValidFullNumber()){
              phoneInput.setError("Phone number is incorrect");
              return;
          }
          Intent intent = new Intent(EnterMobileNumber.this, VerifyActivity.class);
          intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
          startActivity(intent);
      });
    }
}
/* import android.app.Application;
import com.google.firebase.FirebaseApp;*/