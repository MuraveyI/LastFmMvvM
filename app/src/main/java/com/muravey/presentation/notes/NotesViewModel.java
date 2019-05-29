package com.muravey.presentation.notes;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.muravey.entity.NotesEntity;


public class NotesViewModel extends ViewModel {


    MutableLiveData<NotesEntity> notes;

    public NotesViewModel() {
        notes.getValue();
    }


    public void addNotes() {
        notes.setValue(notes.getValue());
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
