package com.example.peoplehub.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peoplehub.R;
import com.example.peoplehub.databinding.FragmentPersonRegisterBinding;
import com.example.peoplehub.ui.viewmodel.PersonRegisterViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PersonRegisterFragment extends Fragment {
    private FragmentPersonRegisterBinding binding;
    private PersonRegisterViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_register ,container,false);
        binding.setPersonRegisterFragment(this);
        binding.setPersonRegisterToolbarTitle("Person Register");

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PersonRegisterViewModel.class);
    }

    public void btnSave(String personName, String personTel){
       viewModel.save(personName,personTel);
    }
}