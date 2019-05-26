package com.muravey.presentation.counter;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.muravey.R;

public class CounterFragment extends Fragment {

    private CounterViewModel mViewModel;
    private TextView mCounterTV;
    private Button mIncrement;
    private Button mDecrement;


    public static CounterFragment newInstance() {
        return new CounterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.counter_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCounterTV = view.findViewById(R.id.counter);
        mIncrement = view.findViewById(R.id.counter_increment);
        mDecrement = view.findViewById(R.id.counter_decrement);

        mIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.increment();
            }
        });


        mDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.decrement();
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if (getActivity() == null) return;


        mViewModel = ViewModelProviders.of(getActivity())
                .get(CounterViewModel.class);


        mViewModel.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null) {
                    mCounterTV.setText(integer.toString());
                }


            }
        });


    }

}
