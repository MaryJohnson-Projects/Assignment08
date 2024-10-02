/*
    Assignment 07
    SelectDOBFragment.java
    Mary Johnson & Cayden Renegar
    Group 18
 */

package com.example.assignment08;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment08.databinding.FragmentSelectDOBBinding;

import java.util.Calendar;

public class SelectDOBFragment extends Fragment {

    public SelectDOBFragment() {
        // Required empty public constructor
    }

    FragmentSelectDOBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectDOBBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String[] dateOfBirth = new String[1];
        final boolean[] selected = new boolean[1];

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.YEAR, -18);
        binding.datePicker.setMaxDate(c.getTimeInMillis());

        binding.datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateOfBirth[0] = monthOfYear+"/"+dayOfMonth+"/"+year;
                selected[0] = true;
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelDOB();
            }
        });

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected[0]) {
                    mListener.sendDOB(dateOfBirth[0]);
                } else {
                    Toast.makeText(getActivity(), "Please select date", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    SelectDOBFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectDOBFragmentListener) context;
    }

    interface SelectDOBFragmentListener {
        void sendDOB(String dob);
        void cancelDOB();
    }

}