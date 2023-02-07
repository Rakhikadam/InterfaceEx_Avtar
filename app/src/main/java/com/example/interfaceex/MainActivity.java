package com.example.interfaceex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    public BodypartListner listner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);

        PagerAdpter adpter = new PagerAdpter(getSupportFragmentManager());
        pager.setAdapter(adpter);




    }
    class PagerAdpter extends FragmentPagerAdapter{

        public PagerAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position ==0){
                return new first_fragment();
            }
            else if (position ==1){
                return new second_fragement();
            }


            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


    interface BodypartListner{
        void AddItem(int face1);
        void AddItem1(int body2);
        void AddItem2(int legs3);

    }
}