package com.paniwala.paniwalaforbusiness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.paniwala.paniwalaforbusiness.model.UserModel;

public class PersonalDetails extends AppCompatActivity {
    EditText userNameInput,companyName;
    ProgressBar progressBar;
    Button btnSubmit;
    String phoneNumber;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        btnSubmit = findViewById(R.id.submit_btn);
        userNameInput = findViewById(R.id.admin_name);
        companyName = findViewById(R.id.company_name);
        progressBar = findViewById(R.id.submit_progress_bar);

        phoneNumber = getIntent().getExtras().getString("phone");
        getUsername();
        //getCompanyname();

        btnSubmit.setOnClickListener(view -> {
          setUsername();
        });


    }

    void  setUsername(){
        String username= userNameInput.getText().toString();
        if(username.isEmpty() || username.length()<3){
            userNameInput.setError("Name should be at least 3 characters");
            return;
            }
        setInProgress(true);
        if (userModel!=null){
            userModel.setUsername(username);
        }
        else {
          userModel = new UserModel(phoneNumber,username,Timestamp.now());
        }
        FirebaseUtil.currentUserDetails().set(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(PersonalDetails.this,Dashboard.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });
    }


    void  getUsername(){
        setInProgress(true);
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                setInProgress(false);
                if(task.isSuccessful()){
                   userModel= task.getResult().toObject(UserModel.class);

                   if(userModel!=null){
                       userNameInput.setText(userModel.getUsername());

                   }

                }

            }
        });

    }
// This is doubtable portion
//   void  getCompanyname(){
//
//   }

    void setInProgress(boolean inProgress){
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            btnSubmit.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            btnSubmit.setVisibility(View.VISIBLE);
        }
    }
}