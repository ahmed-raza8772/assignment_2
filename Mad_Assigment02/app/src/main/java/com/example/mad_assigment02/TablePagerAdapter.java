package com.example.mad_assigment02;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TablePagerAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 4;

    public TablePagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment_Course();
            case 1:
                return new Fragment_Enrollment();
            case 2:
                return new Fragment_Student();
            case 3:
                return new Fragment_Teacher();
            default:
                return new Fragment_Course();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
