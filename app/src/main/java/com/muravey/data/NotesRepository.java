package com.muravey.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.muravey.entity.NotesEntity;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {


    private MutableLiveData<List<NotesEntity>> notesLiveData = new MutableLiveData<>();
    private ArrayList<NotesEntity> notes = new ArrayList<>();

    LiveData<List<NotesEntity>> getNotes() {
        return notesLiveData;
    }

    void addNote(NotesEntity note) {
        notes.add(note);
        notesLiveData.setValue(notes);
    }

    NotesEntity getNote(int position) {
        return notes.get(position);

    }
}
