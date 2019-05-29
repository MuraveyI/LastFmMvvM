package com.muravey.presentation.counter;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muravey.R;
import com.muravey.presentation.counter.recycler.ActionHistoryAdapter;

import java.util.Date;
import java.util.List;

public class CounterHistoryFragment extends Fragment {


    private CounterViewModel mViewModel;
    private ActionHistoryAdapter mAdapter;


    public static CounterHistoryFragment newInstance() {
        return new CounterHistoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.history_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if (getActivity() == null) return;

        mViewModel = ViewModelProviders.of(getActivity())
                .get(CounterViewModel.class);

        mViewModel.actionHistory.observe(this, new Observer<List<Pair<String, Date>>>() {
            @Override
            public void onChanged(@Nullable List<Pair<String, Date>> pairs) {
                for (Pair<String, Date> pair : pairs) {
                    Log.d("qwe", pair.toString());

                }
            }
        });

    }
}
