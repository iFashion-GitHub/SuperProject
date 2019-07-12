package com.avy.superproject;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 * Created by leeqiuuu on 2019/7/9
 */
public class MyfragmentViewpageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    public MyfragmentViewpageAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
