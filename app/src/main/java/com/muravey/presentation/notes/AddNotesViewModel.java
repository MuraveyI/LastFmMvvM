package com.muravey.presentation.notes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.util.Date;
import java.util.List;

public class AddNotesViewModel extends ViewModel {
   private MutableLiveData <List<Date>> data;

    public AddNotesViewModel() {

    }

    public LiveData<List<Date>> getData(){
        if(data == null){
            new MutableLiveData<List<Date>>();

            saveData();

        }
        return data;
    }

    private void saveData(){
    }


}
