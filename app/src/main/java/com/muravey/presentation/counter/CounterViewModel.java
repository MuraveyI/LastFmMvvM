package com.muravey.presentation.counter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.util.Pair;
import android.util.Log;

import com.muravey.App;
import com.muravey.data.ActionsRepository;

import java.util.ArrayList;
import java.util.Date;

public class CounterViewModel extends ViewModel {

    MutableLiveData<Integer> counter = new MutableLiveData<>();
    MutableLiveData actionHistory = new MutableLiveData<>();
    private ArrayList<Pair<String, Date>> history = new ArrayList<>();
    private ActionsRepository repository = App.actionsRepository;


    public CounterViewModel() {
        history.add(new Pair<>("init ", new Date()));
        counter.setValue(0);
        actionHistory.setValue(history);

    }

    public void addAction(String action) {
        history.add(new Pair<>(action, new Date()));
        repository.addAction(action);
    }

    void increment() {
        addAction("increment");
        counter.setValue(counter.getValue() + 1);
    }


    void decrement() {
        addAction("decrement ");
        counter.setValue(counter.getValue() - 1);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("qwe", "ViewModel cleared");
    }
}
