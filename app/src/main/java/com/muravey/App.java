package com.muravey;

import android.app.Application;

import com.muravey.data.ActionsRepository;
import com.muravey.data.NotesRepository;

public class App extends Application {
    public static NotesRepository notesRepository;
    public static ActionsRepository actionsRepository;

    @Override
    public void onCreate() {
        super.onCreate();


        notesRepository = new NotesRepository();
        actionsRepository = new ActionsRepository();

    }
}
