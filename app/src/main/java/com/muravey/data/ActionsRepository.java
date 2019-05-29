package com.muravey.data;

import android.arch.lifecycle.MutableLiveData;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionsRepository {

    MutableLiveData<List<Pair<String, Date>>>actionHistory = new MutableLiveData<>();
    private ArrayList<Pair<String, Date>> history = new ArrayList<>();


    public MutableLiveData<List<Pair<String, Date>>>getActionHistory(){
        return actionHistory;
    }

    public void addAction(String action){
        history.add(new Pair<>(action, new Date()));
        actionHistory.setValue(history);
    }
}
