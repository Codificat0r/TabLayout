package com.example.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by usuario on 13/12/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int pageCount;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, int pageCount) {
        super(supportFragmentManager);
        this.pageCount = pageCount;
    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        CustomFragment customFragment = null;
        Bundle arguments = new Bundle();
        switch (position) {
            case 0:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment 1");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 1:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment 2");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 2:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment 3");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 3:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment 4");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 4:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment 5");
                customFragment = customFragment.newInstance(arguments);
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}