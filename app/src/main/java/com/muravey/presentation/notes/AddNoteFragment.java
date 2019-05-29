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
import android.widget.Button;
import android.widget.EditText;

import com.muravey.R;
import com.muravey.entity.NotesEntity;

public class AddNoteFragment extends Fragment {

    public Button buttonSave;
    public EditText mInput1;
    public EditText mInput2;
    public EditText mInput3;
    private NotesViewModel mViewModel;


    public static AddNoteFragment newInstance() {
        return new AddNoteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_note_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mInput1 = view.findViewById(R.id.input1);
        mInput2 = view.findViewById(R.id.input2);
        mInput3 = view.findViewById(R.id.input3);
        buttonSave = view.findViewById(R.id.save);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInput1.setText("click");
                mInput2.setText("click");
                mInput3.setText("click");

            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if (getActivity() == null)
        mViewModel = ViewModelProviders.of(this)
                .get(NotesViewModel.class);


        mViewModel.notes.observe(this, new Observer<NotesEntity>() {
            @Override
            public void onChanged(@Nullable NotesEntity notesEntity) {
                if (notesEntity != null){
                    mInput1.setText(toString());
                    mInput2.setText(toString());
                    mInput3.setText(toString());
                }
            }
        });


    }


}
