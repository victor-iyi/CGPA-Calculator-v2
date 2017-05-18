package com.victoriyiola.cgpacalculator;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.victoriyiola.cgpacalculator.helpers.DrawerAdapter;


public class NavDrawerFragment extends Fragment {

    public final static String PREF_FILE_NAME = "drawerPref";
    public final static String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;

    public NavDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mUserLearnedDrawer = Boolean.valueOf(readFromPref(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (bundle != null) {
            mFromSavedInstanceState = true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_drawer_fragment, container, false);
        createList(view);
        return view;
    }

    private void createList(View view) {
        String[] depts = getResources().getStringArray(R.array.nav_list_items);
        ListView drawerList = (ListView) view.findViewById(R.id.lvDrawerList);
        ListAdapter adapter = new DrawerAdapter(getContext(), android.R.layout.simple_list_item_1,
                R.id.list_text, depts);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = String.valueOf(adapterView.getItemAtPosition(i));
                if (item.equalsIgnoreCase("Saved GPAs"))
                    startActivity(new Intent(getContext(), SavedGPA.class));
                else if (item.equalsIgnoreCase("Saved CGPAs"))
                    startActivity(new Intent(getContext(), SavedCGPA.class));
                else if (item.equalsIgnoreCase("About"))
                    startActivity(new Intent(getContext(), AboutPage.class));
            }
        });
    }

    public void setup(DrawerLayout drawerLayout, final Toolbar toolbar, int fragment_id) {
        View containerView = getActivity().findViewById(fragment_id);
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPref(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }

                getActivity().invalidateOptionsMenu();
            }

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            /* // Animating toolbar
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset < 0.6) {
                    toolbar.setAlpha(1-slideOffset);
                }
            }
            */
        };

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            drawerLayout.openDrawer(containerView);
        }

        drawerLayout.setDrawerListener(mDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public static void saveToPref(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String readFromPref(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, value);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onPause() {
        super.onPause();
    }
}
