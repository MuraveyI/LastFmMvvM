package com.muravey;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.muravey.presentation.counter.CounterFragment;
import com.muravey.presentation.counter.CounterHistoryFragment;
import com.muravey.presentation.notes.AddNoteFragment;
import com.muravey.presentation.notes.NotesFragment;

public class CounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_activity);


        CounterPagerAdapter adapter = new CounterPagerAdapter(getSupportFragmentManager());
        ViewPager viewpager = findViewById(R.id.counter_view_pager);
        viewpager.setAdapter(adapter);


    }

    public class CounterPagerAdapter extends FragmentPagerAdapter {

        private final static int PAGES_COUNT = 4;

        public CounterPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;

            switch (i) {
                case 0:
                    fragment = CounterFragment.newInstance();
                    break;
                case 1:
                    fragment = CounterHistoryFragment.newInstance();
                    break;
                case 2:
                    fragment = AddNoteFragment.newInstance();
                    break;
                case 3:
                    fragment = NotesFragment.newInstance();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return PAGES_COUNT;
        }


    }
}

