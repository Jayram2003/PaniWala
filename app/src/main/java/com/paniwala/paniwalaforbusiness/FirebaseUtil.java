package com.paniwala.paniwalaforbusiness;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {


    public static String currUserId(){

        return FirebaseAuth.getInstance().getUid();
    }

    public static boolean isLoggedIn(){
        if (currUserId()!=null){
            return true;
        }
        return false;
    }

    public  static DocumentReference currentUserDetails(){
        return FirebaseFirestore.getInstance().collection("users").document(currUserId());
    }
}
