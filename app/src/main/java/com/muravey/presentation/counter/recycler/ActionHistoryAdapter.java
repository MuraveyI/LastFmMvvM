package com.muravey.presentation.counter.recycler;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.muravey.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionHistoryAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Pair<String, Date>> mActions;


    public ActionHistoryAdapter(ArrayList<Pair<String, Date>> actions){
        this.mActions = actions;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_notes, viewGroup, false);
        ActionHistoryViewHolder actionHistoryViewHolder = new ActionHistoryViewHolder(view);
        return actionHistoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (mActions.size() > i && i >= 0) {
            mActions.get(i);
        }

    }

    @Override
    public int getItemCount() {
        return mActions.size();
    }

    public void setmActions(List<Pair<String, Date>>actions){
        mActions.clear();
        mActions.addAll(actions);
        notifyDataSetChanged();

    }
}
