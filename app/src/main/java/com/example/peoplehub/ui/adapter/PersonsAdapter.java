package com.example.peoplehub.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peoplehub.R;
import com.example.peoplehub.data.entity.Person;
import com.example.peoplehub.databinding.CardDesignBinding;
import com.example.peoplehub.ui.fragment.HomeFragmentDirections;
import com.example.peoplehub.ui.viewmodel.HomeViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.CardViewHolder>{
    private Context mContext;
    private List<Person> personList;
    private HomeViewModel viewModel;

    public PersonsAdapter(Context mContext, List<Person> personList, HomeViewModel viewModel) {
        this.mContext = mContext;
        this.personList = personList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardDesignBinding binding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design,parent,false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Person person = personList.get(position);
        CardDesignBinding b = holder.binding;
        b.setPerson(person);

        b.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,person.getPersonName() + " Silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.delete(person.getPersonId());
                    }
                }).show();
            }
        });

        b.cardRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragmentDirections.ActionHomeFragmentToPersonDetailsFragment transit = HomeFragmentDirections.actionHomeFragmentToPersonDetailsFragment(person);
                Navigation.findNavController(v).navigate(transit);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder{
        private CardDesignBinding binding;

        public CardViewHolder(CardDesignBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
