/*
    Assignment 07
    CreateUserFragment.java
    Mary Johnson & Cayden Renegar
    Group 18
 */

package com.example.assignment08;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment08.databinding.FragmentCreateUserBinding;

public class CreateUserFragment extends Fragment {
    private String selectedDOB = null;
    public void setSelectedDOB(String dob){
        Log.d("demo", "setSelectedDOB: test");
        this.selectedDOB = dob;
    }
    private String selectedState = null;
    public void setSelectedState(String country){
        this.selectedState = country;
    }

    private String selectedMaritalStatus = null;
    public void setSelectedMaritalStatus(String maritalStatus){ this.selectedMaritalStatus = maritalStatus; }

    private String selectedEducation = null;
    public void setSelectedEducation(String education){
        this.selectedEducation = education;
    }


    public CreateUserFragment() {
        // Required empty public constructor
    }


    FragmentCreateUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateUserBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.selectDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoDOB();
            }
        });

        binding.selectYourCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoState();
            }
        });

        binding.selectMari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoMarital();
            }
        });

        binding.selectedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoEdu();
            }
        });

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.editName.getText().toString();
                String email = binding.editEmail.getText().toString();
                String age = binding.editAge.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your name", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your email", Toast.LENGTH_SHORT).show();
                } else if (age.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your age", Toast.LENGTH_SHORT).show();
                } else if (selectedState == null) {
                    Toast.makeText(getActivity(), "Please select your country", Toast.LENGTH_SHORT).show();
                } else if (selectedDOB == null) {
                    Toast.makeText(getActivity(), "Please select your date of birth", Toast.LENGTH_SHORT).show();
                } else if (selectedMaritalStatus == null) {
                    Toast.makeText(getActivity(), "Please select your marital status", Toast.LENGTH_SHORT).show();
                } else if (selectedEducation == null) {
                    Toast.makeText(getActivity(), "Please select your education", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(name, email, age, selectedState, selectedDOB, selectedMaritalStatus, selectedEducation);
                    mListener.gotoProfile(user);
                }


            }
        });

        if(selectedDOB != null){
            Log.d("demo", "!!! dob set !!!");
            binding.dobValue.setText(selectedDOB);
        }
        if(selectedState != null){
            binding.countryValue.setText(selectedState);
        }
        if(selectedMaritalStatus != null){
            binding.mariValue.setText(selectedMaritalStatus);
        }
        if(selectedEducation != null){
            binding.eduValue.setText(selectedEducation);
        }


    }

    CreateUserFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (CreateUserFragmentListener) context;
    }


    interface CreateUserFragmentListener {
        void gotoDOB();
        void gotoState();
        void gotoMarital();
        void gotoEdu();
        void gotoProfile(User user);
    }
}