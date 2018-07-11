package com.example.aldres.lifeisrpg;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Aldres on 23.06.2018.
 */

public class CustomFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new ProfileFragment();
            case 1: return new TasksFragment();
            case 2: return new TasksFragment();
            default: return new ProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Profile";
            case 1:
                return "Tasks";
            default:
                return "Try";
        }
    }
}
