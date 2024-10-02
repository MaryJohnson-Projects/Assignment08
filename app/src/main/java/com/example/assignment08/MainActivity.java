/*
    Assignment 07
    MainActivity.java
    Mary Johnson & Cayden Renegar
    Group 18
 */

package com.example.assignment08;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        MainFragment.MainFragmentListener,
        CreateUserFragment.CreateUserFragmentListener,
        SelectDOBFragment.SelectDOBFragmentListener,
        SelectCountryFragment.SelectCountryFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new MainFragment())
                .commit();
    }

    @Override
    public void goToStart() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new CreateUserFragment(), "createuser-fragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoDOB() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectDOBFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoCountry() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectCountryFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoProfile(User user) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ProfileFragment.newInstance(user))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendDOB(String dob) {
        CreateUserFragment fragment = (CreateUserFragment) getSupportFragmentManager().findFragmentByTag("createuser-fragment");
        if (fragment!=null){
            fragment.setSelectedDOB(dob);
        } else {
            Log.d("demo", "fragmentissue");
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelDOB() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendCountry(String country) {
        CreateUserFragment fragment = (CreateUserFragment) getSupportFragmentManager().findFragmentByTag("createuser-fragment");
        if (fragment!=null){
            fragment.setSelectedCountry(country);
        } else {
            Log.d("demo", "fragmentissue");
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelCountry() {
        getSupportFragmentManager().popBackStack();
    }
}