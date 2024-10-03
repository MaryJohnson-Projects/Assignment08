package com.example.assignment08;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.assignment08.databinding.FragmentSelectEducationBinding;

public class SelectEducationFragment extends Fragment {


    public SelectEducationFragment() {
        // Required empty public constructor
    }

    FragmentSelectEducationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectEducationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Found this method on a Stack Overflow forum
        // https://stackoverflow.com/questions/27836405/create-radiobutton-dynamically-with-string-array
        for (int i = 0; i < Data.education.length; i++)
        {
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(Data.education[i]);
            radioButton.setId(i);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            binding.radioGroup.addView(radioButton, params);
        }

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelEducation();
            }
        });

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radId = binding.radioGroup.getCheckedRadioButtonId();
                if (radId == -1) {
                    Toast.makeText(getActivity(), "Please select education", Toast.LENGTH_SHORT).show();
                } else {
                    mListener.sendEducation( Data.education[radId] );
                }
            }
        });
    }

    SelectEducationFragment.SelectEducationFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (com.example.assignment08.SelectEducationFragment.SelectEducationFragmentListener) context;
    }

    interface SelectEducationFragmentListener {
        void sendEducation(String education);
        void cancelEducation();
    }
}