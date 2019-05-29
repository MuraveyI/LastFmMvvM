package com.muravey.presentation.notes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muravey.R;
import com.muravey.entity.NotesEntity;
import com.muravey.presentation.counter.recycler.ActionHistoryAdapter;

import java.util.ArrayList;

public class NotesFragment extends Fragment {

    private NotesViewModel mViewModel;
    private ActionHistoryAdapter actionHistoryAdapter;

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_fragment, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(actionHistoryAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()==null)return;
        mViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        mViewModel.notes.observe(this, new Observer<NotesEntity>() {
            @Override
            public void onChanged(@Nullable NotesEntity notesEntity) {
                mViewModel.onCleared();
                mViewModel.addNotes();
            }
        });
    }

}
