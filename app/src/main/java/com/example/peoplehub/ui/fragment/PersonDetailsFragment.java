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
import com.example.peoplehub.data.entity.Person;
import com.example.peoplehub.databinding.FragmentPersonDetailsBinding;
import com.example.peoplehub.ui.viewmodel.PersonDetailsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PersonDetailsFragment extends Fragment {
    private FragmentPersonDetailsBinding binding;
    private PersonDetailsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_details,container,false);
        binding.setPersonDetailsFragment(this);
        binding.setPersonDetailsToolbarTitle("Person Details");

        PersonDetailsFragmentArgs bundle = PersonDetailsFragmentArgs.fromBundle(getArguments());
        Person person = bundle.getPerson();
        binding.setPerson(person);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PersonDetailsViewModel.class);
    }

    public void btnUpdate(int personId, String personName, String personTel){
        viewModel.update(personId,personName,personTel);
    }
}

