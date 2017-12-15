package com.example.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by usuario on 13/12/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int pageCount;
    private ArrayList<String> titulos;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, int pageCount, ArrayList<String> titulos) {
        super(supportFragmentManager);
        this.pageCount = pageCount;
        this.titulos = titulos;
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
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment uno");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 1:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment dos");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 2:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment tres");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 3:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment cuatro");
                customFragment = customFragment.newInstance(arguments);
                break;
            case 4:
                arguments.putString(CustomFragment.KEY_MESSAGE, "Fragment cinco");
                customFragment = customFragment.newInstance(arguments);
                break;
        }
        return customFragment;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }
}
