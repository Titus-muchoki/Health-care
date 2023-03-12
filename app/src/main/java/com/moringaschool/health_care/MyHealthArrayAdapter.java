package com.moringaschool.health_care;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyHealthArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mHealth;
    private String[] mCuisines;

    public MyHealthArrayAdapter(Context mContext, int resource, String[] mHealth, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mHealth = mHealth;
        this.mCuisines = mCuisines;
    }
    @Override
    public Object getItem(int position) {
        String health = mHealth[position];
        String cuisine = mCuisines[position];
        return String.format("%s \nServes great: %s", health, cuisine);
    }

    @Override
    public int getCount() {
        return mHealth.length;
    }
}
