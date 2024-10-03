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
        SelectStateFragment.SelectStateFragmentListener,
        SelectMaritalStatusFragment.SelectMaritalStatusFragmentListener,
        SelectEducationFragment.SelectEducationFragmentListener
{

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
    public void gotoState() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectStateFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoMarital() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectMaritalStatusFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoEdu() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectEducationFragment())
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
    public void sendState(String state) {
        CreateUserFragment fragment = (CreateUserFragment) getSupportFragmentManager().findFragmentByTag("createuser-fragment");
        if (fragment!=null){
            fragment.setSelectedState(state);
        } else {
            Log.d("demo", "fragmentissue");
        }
        getSupportFragmentManager().popBackStack();
    }

    public void cancelState() {
        getSupportFragmentManager().popBackStack();
    }


    @Override
    public void sendEducation(String education) {
        CreateUserFragment fragment = (CreateUserFragment) getSupportFragmentManager().findFragmentByTag("createuser-fragment");
        if (fragment!=null){
            fragment.setSelectedEducation(education);
        } else {
            Log.d("demo", "fragmentissue");
        }
        getSupportFragmentManager().popBackStack();
    }

    public void cancelEducation() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendMaritalStatus(String maritalStatus) {
        CreateUserFragment fragment = (CreateUserFragment) getSupportFragmentManager().findFragmentByTag("createuser-fragment");
        if (fragment!=null){
            fragment.setSelectedMaritalStatus(maritalStatus);
        } else {
            Log.d("demo", "fragmentissue");
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelMaritalStatus() {
        getSupportFragmentManager().popBackStack();
    }
}