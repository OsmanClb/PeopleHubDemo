package com.example.peoplehub.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.peoplehub.R;
import com.example.peoplehub.data.entity.Person;
import com.example.peoplehub.databinding.FragmentHomeBinding;
import com.example.peoplehub.ui.adapter.PersonsAdapter;
import com.example.peoplehub.ui.viewmodel.HomeViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        binding.setHomeFragment(this);
        binding.setHomeFragmentToolbarTitle("Persons");

        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarHome);

        binding.rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.personsList.observe(getViewLifecycleOwner(),list -> {
            PersonsAdapter adapter = new PersonsAdapter(requireContext(),list,viewModel);
            binding.setPersonAdapter(adapter);
        });

        //Menu Provider
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);
                MenuItem item = menu.findItem(R.id.action_search);
                SearchView searchView = (SearchView) item.getActionView();
                assert searchView != null;
                searchView.setOnQueryTextListener(HomeFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    public void fabClick(View view){
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_personRegisterFragment);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.search(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.search(newText);
        return false;
    }
}