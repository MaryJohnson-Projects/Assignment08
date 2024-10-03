/*
    Assignment 07
    ProfileFragment.java
    Mary Johnson & Cayden Renegar
    Group 18
 */

package com.example.assignment08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment08.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM_USER = "ARG_PARAM_USER";

    private User mUser;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(User user) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUser = (User) getArguments().getSerializable(ARG_PARAM_USER);
        }
    }

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentProfileBinding.inflate(inflater, container, false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.nameValue.setText(mUser.getName());
        binding.emailValue.setText(mUser.getEmail());
        binding.ageValue.setText(mUser.getAge());
        binding.countryValue.setText(mUser.getState());
        binding.dobValue.setText(mUser.getDob());
    }
}