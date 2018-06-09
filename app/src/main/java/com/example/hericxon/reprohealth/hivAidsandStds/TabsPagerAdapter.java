package com.example.hericxon.reprohealth.hivAidsandStds;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HERICXON on 04-Jun-18.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public TabsPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}

  /*  String[] titles = new String[]{"HIV/AIDs","STDs"};

    public TabsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    *//**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     *//*
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                HivAidsFragment hivAidsFragment =new HivAidsFragment();
                return hivAidsFragment;
            case 1:
                StdsFragment stdsFragment = new StdsFragment();
                return stdsFragment;
        }
        return null;
    }

    *//**
     * Return the number of views available.
     *//*
    @Override
    public int getCount() {
        return 0;
    }
}
*/