package com.example.jayhind.facebook_login_z;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main2Activity extends AppCompatActivity {

    LoginButton button;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
        button = findViewById(R.id.login_button);
        button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile mProfile = Profile.getCurrentProfile();
                String firstName = mProfile.getFirstName();
                Toast.makeText(Main2Activity.this, firstName, Toast.LENGTH_SHORT).show();
               Toast.makeText(Main2Activity.this, "firstName", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(Main2Activity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Profile mProfile = Profile.getCurrentProfile();
//                String firstName = mProfile.getFirstName();
//                Toast.makeText(Main2Activity.this, firstName, Toast.LENGTH_SHORT).show();
//               //Toast.makeText(Main2Activity.this, loginResult.toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Toast.makeText(Main2Activity.this, error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}