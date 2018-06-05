package com.example.hericxon.reprohealth.hivAidsandStds;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by HERICXON on 04-Jun-18.
 */

public class TabsPager extends FragmentStatePagerAdapter {

    String[] titles = new String[]{"HIV/AIDs","STDs"};

    public TabsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
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

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 0;
    }
}
