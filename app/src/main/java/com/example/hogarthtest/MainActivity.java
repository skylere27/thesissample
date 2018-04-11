package com.example.hogarthtest;

import java.util.Arrays;
import java.util.*;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.FacebookException;
import com.facebook.login.widget.LoginButton;
import com.facebook.AccessToken;

public class MainActivity extends AppCompatActivity {

    //private static final String EMAIL = "email"; FROM https://developers.facebook.com/docs/facebook-login/android/v2.2

    LoginButton loginButton;
    //loginButton.setReadPermissions(Arrays.asList(EMAIL)); FROM https://developers.facebook.com/docs/facebook-login/android/v2.2
    boolean loggedIn = AccessToken.getCurrentAccessToken() == null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("CREATE", "Entered onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CallbackManager callbackManager = CallbackManager.Factory.create();
        Log.i("CREATE", "Defined callbackManager");

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // THIS IS THE CALL TO ACCESS PERMISSIONS
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile"));
                // want to access more permissions???
                Intent intent = new Intent(MainActivity.this, Home.class); // goes to Home
                startActivity(intent);
            };
        });

        // Callback registration, only need to do it on login button or on login manager but not both
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // loginResult.getAccessToken() is access token
                // loginResult.getRecentlyDeniedPermissions() is a set of strings
                // loginResult.getRecentlyGrantedPermissions() is a set of strings

                for (String s: loginResult.getRecentlyGrantedPermissions()) {
                    Log.i("Login Result", "GRANTED: " + s);
                }
                for (String s: loginResult.getRecentlyDeniedPermissions()) {
                    Log.i("Login Result", "DENIED: " + s);
                }
                // Want it to switch pages after login and put it here but doesn't even access it here...
//                Intent intent = new Intent(MainActivity.this, Permissions.class); //creates a new page
//                startActivity(intent);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        Log.i("CREATE", "loginButton callbackManager");

//          ONLY NEEDED LOGIN BUTTON CALLBACK
//        LoginManager.getInstance().registerCallback(callbackManager,
//                new FacebookCallback<LoginResult>() {
//                    @Override
//                    public void onSuccess(LoginResult loginResult) {
//                        // App code
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        // App code
//                    }
//
//                    @Override
//                    public void onError(FacebookException exception) {
//                        // App code
//                    }
//                });
//        Log.i("CREATE", "LoginManager registerCallback");
    }

    // Wanted a login feature but not gonna do it
//    public void login() {
//        loggedIn = true;
//    }
//
//    public void logout() {
//        loggedIn = false;
//    }
}
